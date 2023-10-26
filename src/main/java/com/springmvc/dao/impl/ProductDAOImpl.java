package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.ProductDAO;
import com.springmvc.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session.createQuery("from Product p order by p.productId desc", Product.class).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean create(Product product) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Product find(Integer productId) {
		Session session = sessionFactory.openSession();
		try {
			Product product = session.get(Product.class, productId);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean update(Product product) {
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(Integer productId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(productId));
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Product> search(String keyWord) {
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session
					.createQuery("from Product where productName like :keyword", Product.class)
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
	public List<Product> pading(Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session.createQuery("from Product", Product.class).setFirstResult((pageNo-1)*pageSize)
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
	public int count() {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Product", Product.class).list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<Product> searchProduct(String keyWord, Integer pageNo, Integer pageSize) {
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session
					.createQuery("from Product where lower(productName) like lower(:keyword)", Product.class)
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
	public int countProduct(String keyWord) {
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Product where lower(productName) like lower(:keyword)", Product.class)
					.setParameter("keyword", "%" + keyWord.toLowerCase() + "%").list().size();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return total;
	}

}
