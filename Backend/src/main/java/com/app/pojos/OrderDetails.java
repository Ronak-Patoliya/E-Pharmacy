package com.app.pojos;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {
	@Id
	@Column(unique = true, nullable = false, name = "orderdetail_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer detailsId;

	@Column(name = "total_price")
	private String totalPrice;
	
	@Column(name = "bill_date")
	private Date billDate;
	
	@Column(name = "order_qty")
	private String orderQuantity;
	
	@OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

	@OneToMany(cascade = CascadeType.ALL,mappedBy ="shoppingCart")
	private List<MedicalProduct> products;

	public Integer getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(Integer detailsId) {
		this.detailsId = detailsId;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}



	

	public List<MedicalProduct> getProducts() {
		return products;
	}

	public void setProducts(List<MedicalProduct> products) {
		this.products = products;
	}

	

}
