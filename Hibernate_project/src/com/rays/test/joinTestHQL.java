package com.rays.test;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class joinTestHQL {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery(
				"select u.id, u.firstName, u.lastName, u.loginId, u.password, u.dob, u.address, m.id, m.name, m.maths from UserDTO u, MarksheetDTO m where u.id = m.id");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object[] dto = (Object[]) it.next();

			System.out.print(dto[0]);
			System.out.print("\t " + "\t" + dto[1]);
			System.out.print("\t " + "\t" + dto[2]);
			System.out.print("\t " + "\t" + dto[3]);
			System.out.print("\t " + "\t" + dto[4]);
			System.out.print("\t " + "\t" + dto[5]);
			System.out.print("\t " + "\t" + dto[6]);
			System.out.print("\t " + "\t" + dto[7]);
			System.out.print("\t " + "\t" + dto[8]);
			System.out.println("\t " + "\t" + dto[9]);
		}

		tx.commit();
		session.close();

	}

}
