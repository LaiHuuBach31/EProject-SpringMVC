package com.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productStatus")
	private Boolean productStatus;
	@Column(name = "price")
	private Float price;
	@Column(name = "image")
	private String image;
	@Column(name = "description")
	private String description;
	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
	private Category category;
	
	public Product() {
		
	}

	public Product(Integer productId, String productName, Boolean productStatus, Float price, String image,
			String description, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productStatus = productStatus;
		this.price = price;
		this.image = image;
		this.description = description;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Boolean getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Boolean productStatus) {
		this.productStatus = productStatus;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
