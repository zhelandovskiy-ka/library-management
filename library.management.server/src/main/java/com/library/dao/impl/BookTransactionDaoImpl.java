package com.library.dao.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.inject.Inject;
import com.library.dao.BookDao;
import com.library.dao.BookTransactionDao;
import com.library.dao.UserDao;
import com.library.entity.BookTransaction;
import com.library.util.HibernateUtil;

public class BookTransactionDaoImpl implements BookTransactionDao {
	private SessionFactory sessionFactory;
	private final BookDao bookDao;
	private final UserDao userDao;

	@Inject
	public BookTransactionDaoImpl(BookDao bookDao, UserDao userDao) {
		this.bookDao = bookDao;
		this.userDao = userDao;
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public BookTransaction create(BookTransaction bookTransaction) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {

			transaction = session.beginTransaction();
			session.persist(bookTransaction);
			transaction.commit();

			return getById(bookTransaction.getId());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		throw new RuntimeException("BookTransaction create error");
	}

	@Override
	public List<BookTransaction> getAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from BookTransaction", BookTransaction.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	@Override
	public BookTransaction update(BookTransaction bookTransaction) {
		if (getById(bookTransaction.getId()) == null)
			throw new RuntimeException("BookTransaction not found");

		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {

			transaction = session.beginTransaction();
			session.merge(bookTransaction);
			transaction.commit();

			return bookTransaction;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		throw new RuntimeException("BookTransaction update error");
	}

	@Override
	public boolean delete(Long id) {
		Transaction transaction = null;

		BookTransaction bookTransaction = getById(id);

		if (bookTransaction == null)
			throw new RuntimeException("BookTransaction not found");

		try (Session session = sessionFactory.openSession()) {

			transaction = session.beginTransaction();
			session.remove(bookTransaction);
			session.getTransaction().commit();

			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public BookTransaction getById(Long id) {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from BookTransaction where id=:id", BookTransaction.class)
					.setParameter("id", id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new RuntimeException("BookTransaction not found");
	}

	@Override
	public BookTransaction issueBook(Long userId, Long bookId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = null;

			BookTransaction bookTransaction = new BookTransaction();
			bookTransaction.setBook(bookDao.getById(bookId));
			bookTransaction.setUser(userDao.getById(bookId));
			bookTransaction.setIssueDate(LocalDateTime.now());

			transaction = session.beginTransaction();
			session.persist(bookTransaction);
			transaction.commit();

			return bookTransaction;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public BookTransaction returnBook(Long bookTtransactionId) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = null;

			BookTransaction bookTransaction = getById(bookTtransactionId);
			bookTransaction.setReturnDate(LocalDateTime.now());

			transaction = session.beginTransaction();
			session.merge(bookTransaction);
			transaction.commit();

			return bookTransaction;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
