package com.rays.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;
import com.rays.auction.Bids;

public class TestTransientPersistence {
	public static void main(String[] args) {
		Bids bids = new Bids();

		bids.setId(4);

		bids.setAmount(4000);

		bids.setTimeStamp("aaaa");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);

		Set s = item.getBids();

		s.add(bids);

		tx.commit();
		session.close();

	}

}
