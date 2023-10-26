package com.springmvc.dto.product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.model.Category;


public class UpdateDTO {
	private Integer productId;
	@NotEmpty(message = "ProductName is required.")
	private String productName;
	@NotNull(message = "ProductName is required.")
	private Boolean productStatus;
	@NotNull(message = "Price is required.")
	@Min(value = 0, message = "The lowest price is zero")
	private Float price;
	private MultipartFile image;
	private String description;
	private Category category;
	
	public UpdateDTO() {
		// TODO Auto-generated constructor stub
	}

	public UpdateDTO(Integer productId, @NotEmpty(message = "ProductName is required.") String productName,
			@NotNull(message = "ProductName is required.") Boolean productStatus,
			@NotNull(message = "Price is required.") @Min(value = 0, message = "The lowest price is zero") Float price,
			MultipartFile image, String description, Category category) {
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
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
