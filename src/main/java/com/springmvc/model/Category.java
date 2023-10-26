package com.springmvc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "categoryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@Column(name = "categoryName")
	private String categoryName;
	@Column(name = "categoryStatus")
	private Boolean categoryStatus;
	@OneToMany(mappedBy = "category")
	private Set<Product> products;

	public Category() {
		
	}

	public Category(Integer categoryId, String categoryName, Boolean categoryStatus, Set<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryStatus = categoryStatus;
		this.products = products;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(Boolean categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
