package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.CategoryDAO;
import com.springmvc.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session.createQuery("from Category", Category.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public boolean create(Category category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public Category find(Integer categoryId) {
		Session session = sessionFactory.openSession();
		try {
			Category category = session.get(Category.class, categoryId);
			return category;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean update(Category category) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(category);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Integer categoryId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(categoryId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Category> search(String keyWord) {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session
					.createQuery("from Category where lower(categoryName) like :keyword", Category.class)
					.setParameter("keyword", "%" + keyWord + "%").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Category> pading(Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session.createQuery("from Category", Category.class)
					.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int count() {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Category", Category.class).list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<Category> searchCategory(String keyWord, Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Category> list = session
					.createQuery("from Category where lower(categoryName) like lower(:keyword)", Category.class)
					.setParameter("keyword", "%" + keyWord + "%").setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int countCategory(String keyWord) {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Category where lower(categoryName) like lower(:keyword)", Category.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

}
