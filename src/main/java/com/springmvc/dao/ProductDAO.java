package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Product;

public interface ProductDAO {
	public List<Product> getAll();
	public boolean create(Product product);
	public Product find(Integer productId);
	public boolean update(Product product);
	public boolean delete(Integer productId);
	public List<Product> search(String keyWord);
	public List<Product> pading(Integer pageNo, Integer pageSize);
	public int count();
	public List<Product> searchProduct(String keyWord, Integer pageNo, Integer pageSize);
	public int countProduct(String keyWord);
}
