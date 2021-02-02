package com.app.pojos;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "PharmacyManager")
	private boolean isPharmacyManager;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orders;

	private String address;

	private String city;

	private String state;
	
	@OneToOne(cascade =  CascadeType.ALL,mappedBy = "customer")
    private OrderDetails shoppingCart;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isPharmacyManager() {
		return isPharmacyManager;
	}

	public void setPharmacyManager(boolean isPharmacyManager) {
		this.isPharmacyManager = isPharmacyManager;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Customer() {
		super();
	}

	public Customer(Integer customerId, String firstName, String lastName, String email, String password,
			String mobileNo, boolean isPharmacyManager, List<Order> orders, String address, String city, String state) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.isPharmacyManager = isPharmacyManager;
		this.orders = orders;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", mobileNo=" + mobileNo + ", isPharmacyManager="
				+ isPharmacyManager + ", address=" + address + ", city=" + city + ", state=" + state + "]";
	}

}
