package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.pojos.Customer;
import com.app.pojos.MedicalProduct;
import com.app.repository.ICustomerDao;
import com.app.repository.IMedicalProductDao;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
	
        @Autowired
		private ICustomerDao dao;

		public CustomerController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		@GetMapping
		public ResponseEntity<?> getAllCustomerDetails() {
			List<Customer> customers = dao.findAll();
			return ResponseEntity.ok(customers);
		}

		@GetMapping("/{customer_id}")
		public ResponseEntity<?> getCustomerDetails(@PathVariable int customer_id) {
			System.out.println("in get customer dtls " + customer_id);
			Optional<Customer> optional = dao.findById(customer_id);

			return ResponseEntity.ok(optional);
		}

		@PostMapping
		public ResponseEntity<?> addCustomerDetails(@RequestBody @Valid Customer c) {
			return new ResponseEntity<>(dao.save(c), HttpStatus.CREATED);
		}
		
		@PostMapping("/login")
		public ResponseEntity<?> loginCustomer(@RequestBody Customer c)
		{
			String email=c.getEmail();
			String password=c.getPassword();
			Optional<Customer> customer=null;
			if(email!=null && password!=null) {
				customer=dao.findByEmailAndPassword(email, password);
			}
			return ResponseEntity.ok(customer);
		}
		
		@PutMapping("/{customer_id}")
		public ResponseEntity<?> updateCustomerDetails(@PathVariable int customer_id, @RequestBody Customer customer) {
			System.out.println("in update emp " + customer_id + " " + customer);
			Optional<Customer> optional = dao.findById(customer_id);
			Customer existingCustomer = optional.get();// DETACHED
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setPassword(customer.getPassword());
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setCity(customer.getCity());
			existingCustomer.setState(customer.getState());
			existingCustomer.setMobileNo(customer.getMobileNo());
			existingCustomer.setPharmacyManager(customer.isPharmacyManager());
				return new ResponseEntity<>(dao.save(existingCustomer), HttpStatus.OK);

		}
		
		@DeleteMapping("/{customer_id}")
		public ResponseEntity<?> deleteCustomerDetails(@PathVariable  int customer_id) {
			System.out.println("in delete emp " + customer_id);
			Optional<Customer> optional = dao.findById(customer_id);
				dao.deleteById(customer_id);
				return new ResponseEntity<>("customer rec deleted with ID " + customer_id, HttpStatus.OK);

		}
}
