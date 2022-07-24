package com.foodbox.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.foodbox.entities.Category;

public class CategoryDao {

	private SessionFactory factory;

	public CategoryDao(SessionFactory factory) {
		this.factory = factory;
	}

	// Saves the Category data to DB
	public int saveCategory(Category cat) {

		int catId = 0;
		try {
			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();
			catId = (int) session.save(cat);
			tx.commit();

			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return catId;
	}

	public List<Category> getCategories() {

		Session s = this.factory.openSession();
		Query query = s.createQuery("from Category");
		List<Category> list = query.list();

		return list;
	}

	// Method for getting single category object
	public Category getCategoryById(int cid) {

		Category cat = null;

		try {

			Session session = this.factory.openSession();
			cat = session.get(Category.class, cid);
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cat;
	}

}
