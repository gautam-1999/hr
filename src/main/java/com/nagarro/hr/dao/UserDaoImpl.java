package com.nagarro.hr.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.hr.model.User;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(String username, String password) {
		Session session = sessionFactory.openSession();
		List<User> users = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			users = session.createQuery("FROM User").getResultList();
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return users;

	}
}
