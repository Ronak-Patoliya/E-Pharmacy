package com.app.pojos;

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
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;

	@Column(name = "order_price")
	private String OrderPrice;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "shipment_id")
	private int shipmentId;

	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name = "payment_type")
	private int paymentType;



	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderPrice() {
		return OrderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		OrderPrice = orderPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Order(Integer orderId, String orderPrice, Customer customer, int shipmentId, int paymentId,
			int paymentType) {
		super();
		this.orderId = orderId;
		OrderPrice = orderPrice;
		this.customer = customer;
		this.shipmentId = shipmentId;
		this.paymentId = paymentId;
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", OrderPrice=" + OrderPrice + ", customer=" + customer + ", shipmentId="
				+ shipmentId + ", paymentId=" + paymentId + ", paymentType=" + paymentType + "]";
	}


	
	

	
}
