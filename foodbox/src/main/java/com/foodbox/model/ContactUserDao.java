package com.foodbox.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.foodbox.entities.ContactUser;

public class ContactUserDao {

	private SessionFactory factory;

	public ContactUserDao(SessionFactory factory) {
		this.factory = factory;
	}

	public int saveContactUser(ContactUser contactUser) {

		int contactUserId = 0;

		try {

			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();

			contactUserId = (int) session.save(contactUser);
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contactUserId;
	}

}
