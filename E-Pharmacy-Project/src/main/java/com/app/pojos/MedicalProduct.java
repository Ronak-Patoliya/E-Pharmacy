package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "medical_products")

public class MedicalProduct {
	@Id
	@Column(unique = true, name = "product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "product_name")
	private String name;

	private String description;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "mfg_date")
	private Date mfgDate;

	@Column(name = "exp_date")
	private Date expDate;

	private String company;
	
	@ManyToOne
    @JoinColumn(name="cart_id")
    private OrderDetails shoppingCart;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory category;

	public MedicalProduct() {
	}

	public MedicalProduct(int id, String name, String description, double unitPrice, String imageUrl, Date mfgDate,
			Date expDate, String company, ProductCategory category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.company = company;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "MedicalProduct [id=" + id + ", name=" + name + ", description=" + description + ", unitPrice="
				+ unitPrice + ", imageUrl=" + imageUrl + ", mfgDate=" + mfgDate + ", expDate=" + expDate + ", company="
				+ company + ", category=" + category + "]";
	}

}
