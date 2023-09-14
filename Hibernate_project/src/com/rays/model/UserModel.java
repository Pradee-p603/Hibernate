package com.rays.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class UserModel {
	public void add(UserDTO DTO) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(DTO);

		tx.commit();
		sf.close();

	}

	public void Delete(UserDTO DTO) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.delete(DTO);

		tx.commit();
		sf.close();
	}

	public void Update(UserDTO DTO) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(DTO);

		tx.commit();
		sf.close();
	}

	public UserDTO FindByPk(int id) {
		UserDTO dto = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();
		dto = (UserDTO) session.get(UserDTO.class, id);

		sf.close();
		return dto;

	}

	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Query q = session.createQuery("from UserDTO where loginId = ? and password =?");
		q.setString(0, loginId);
		q.setString(1, password);
		List list = q.list();
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);

		}
		return dto;

	}
	public List search(UserDTO dto , int pageNo , int pageSize) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Criteria criteria = session.createCriteria(UserDTO.class);
		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0 ) {
				criteria.add(Restrictions.eq("firstName", dto.getFirstName()));
				}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.eq("lastName", dto.getLastName()));
				}
			if (dto.getDob() != null && dto.getDob().getTime() > 0) {
				criteria.add(Restrictions.eq("dob",dto.getDob()));
				
			}
			
		
		
		}
		if (pageSize > 0 ) {
			
			pageNo = (pageNo - 1 ) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();
		
		return list;
		
	}

}
