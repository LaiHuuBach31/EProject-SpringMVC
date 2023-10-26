package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Category;

public interface CategoryDAO {
	public List<Category> getAll();
	public boolean create(Category category);
	public Category find(Integer categoryId);
	public boolean update(Category category);
	public boolean delete(Integer categoryId);
	public List<Category> search(String keyWord);
	public List<Category> pading(Integer pageNo, Integer pageSize);
	public int count();
	public List<Category> searchCategory(String keyWord, Integer pageNo, Integer pageSize);
	public int countCategory(String keyWord);
}
