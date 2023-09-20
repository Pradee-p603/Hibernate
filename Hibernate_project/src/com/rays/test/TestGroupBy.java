package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestGroupBy {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("select u.firstName,count(*)from UserDTO u group by u.firstName");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object[] dto = (Object[]) it.next();

			System.out.println(dto[0]);
		}

		tx.commit();
		session.close();

	}

}
