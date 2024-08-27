package com.library.dao.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.dao.BookDao;
import com.library.entity.Book;
import com.library.util.HibernateUtil;

public class BookDaoImpl implements BookDao {
	private SessionFactory sessionFactory;

	public BookDaoImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public String printTest() {
		return "test message";
	}

	@Override
	public Book create(Book book) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			
			transaction = session.beginTransaction();
			session.persist(book);
			transaction.commit();
			
			return book;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		throw new RuntimeException("Book create error");
	}

	@Override
	public List<Book> getAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from Book", Book.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	@Override
	public Book update(Book book) {
		if (getById(book.getId()) == null)
			throw new RuntimeException("Book not found");
		
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			
			transaction = session.beginTransaction();
			session.merge(book);
			transaction.commit();
			
			return book;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		throw new RuntimeException("Book update error");
	}

	@Override
	public boolean delete(Long id) {
		Transaction transaction = null;
		
		Book book = getById(id);
		
		if (book == null)
			throw new RuntimeException("Book not found");
		
		try (Session session = sessionFactory.openSession()) {
			
			transaction = session.beginTransaction();
			session.remove(book);
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
	public Book getById(Long id) {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from Book where id=:id", Book.class)
					.setParameter("id", id)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Book not found");
	}

}
