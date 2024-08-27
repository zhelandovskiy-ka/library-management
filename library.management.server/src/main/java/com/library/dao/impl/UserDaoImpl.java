package com.library.dao.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.dao.UserDao;
import com.library.entity.User;
import com.library.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public UserDaoImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public User create(User user) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			
			transaction = session.beginTransaction();
			session.persist(user);
			transaction.commit();
			
			return user;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		throw new RuntimeException("User create error");
	}

	@Override
	public List<User> getAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from User", User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	@Override
	public User update(User user) {
		if (getById(user.getId()) == null)
			throw new RuntimeException("User not found");
		
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			
			transaction = session.beginTransaction();
			session.merge(user);
			transaction.commit();
			
			return user;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		throw new RuntimeException("User update error");
	}

	@Override
	public boolean delete(Long id) {
		Transaction transaction = null;
		
		User user = getById(id);
		
		if (user == null)
			throw new RuntimeException("User not found");
		
		try (Session session = sessionFactory.openSession()) {
			
			transaction = session.beginTransaction();
			session.remove(user);
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
	public User getById(Long id) {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("from User where id=:id", User.class)
					.setParameter("id", id)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new RuntimeException("User not found");
	}

}
