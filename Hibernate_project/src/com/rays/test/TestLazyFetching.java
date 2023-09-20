package com.rays.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;

public class TestLazyFetching {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);
		
		//when we use lazy fetching then we have to change in hbm.xml file  of auction in which we have to use 
		//lazy fetcing = true;

	// Set s = item.getBids();

	//Iterator it = s.iterator();

		tx.commit();
		session.close();
	}

}
