package com.springmvc.dto.category;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.springmvc.model.Product;

public class CreateDTO {
	
	private Integer categoryId;
	@NotEmpty(message = "Category Name is required.")
	private String categoryName;
	private Boolean categoryStatus;
	private Set<Product> products;

	public CreateDTO() {

	}

	public CreateDTO(Integer categoryId, @NotEmpty(message = "CategoryName is required.") String categoryName,
			Boolean categoryStatus, Set<Product> products) {
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
