package com.springmvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("from User where userName = :userName")
					.setParameter("userName", userName).uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
