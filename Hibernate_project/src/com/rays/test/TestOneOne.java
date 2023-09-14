package com.rays.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.oneone.Address;
import com.rays.oneone.Employee;

public class TestOneOne {
	public static void main(String[] args) {
		
		Address adress = new Address();
		adress.setId(1);
		adress.setStreet("Street1");
		adress.setCity("indore");
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("addu sir");
		emp.setEmpAddress(adress);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		
		
		tx.commit();
		session.close();
	}

}
