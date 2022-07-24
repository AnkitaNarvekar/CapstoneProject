package com.foodbox.model;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.foodbox.entities.User;

public class UserDao {
	private SessionFactory factory;

	/* Constructor */
	public UserDao(SessionFactory factory) {
		this.factory = factory;
	}

	/* Getting User by email and Password */
	public User getUserByEmailAndPassword(String email, String password) {

		User user = null;

		try {
			/* here we will use hql Hibernate Query language to perfrom DB transaction */
			String query = "from User where userEmail =: e and userPassword =:p";
			Session hibernateSession = this.factory.openSession();

			Query q = hibernateSession.createQuery(query);
			q.setParameter("e", email);
			q.setParameter("p", password);

			/*
			 * Because we want single result so we will use unique method not list method of
			 * hibernate
			 */

			user = (User) q.uniqueResult();

			hibernateSession.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
