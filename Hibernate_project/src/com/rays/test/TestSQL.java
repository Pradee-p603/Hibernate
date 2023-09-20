package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rays.dto.UserDTO;

public class TestSQL {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query q = session.createSQLQuery("select * from User");

		List list = q.list();

		Iterator it = list.iterator();

	while (it.hasNext()) {
		Object [] dto= (Object []) it.next();
		System.out.print("\t" + dto[0]);
		System.out.print("\t" + dto[1]);
		System.out.print("\t" + dto[2]);
		System.out.print("\t" + dto[3]);
		System.out.print("\t" + dto[4]);
		System.out.print("\t" + dto[5]);
		System.out.println(dto[6]);
		
	}

		tx.commit();
		sf.close();
		
	}

}
