package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.app.pojos.Order;
import com.app.pojos.ProductCategory;
import com.app.repository.ICustomerDao;
import com.app.repository.IOrderDao;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

	@Autowired
	private IOrderDao dao;

	@GetMapping
	public ResponseEntity<?> getAllOrders() {
		List<Order> orders = dao.findAll();
		return ResponseEntity.ok(orders);
	}

	@GetMapping("{order_id}")
	public ResponseEntity<?> getOrders(@PathVariable int order_id) {
		Optional<Order> optional = dao.findById(order_id);

		return ResponseEntity.ok(optional);
	}

	@PostMapping
	public ResponseEntity<?> addOrdersDetails(@RequestBody @Valid Order order) {
		return new ResponseEntity<>(dao.save(order), HttpStatus.CREATED);
	}

	@PutMapping("/{order_id}")
	public ResponseEntity<?> updateOrdersDetails(@PathVariable int order_id, @RequestBody Order order) {
		System.out.println("in update order " + order_id + " " + order);
		Optional<Order> optional = dao.findById(order_id);
		Order existingOrder = optional.get();
		existingOrder.setOrderPrice(order.getOrderPrice());

		return new ResponseEntity<>(dao.save(existingOrder), HttpStatus.OK);

	}

	@DeleteMapping("/{order_id}")
	public ResponseEntity<?> deleteOrdersDetails(@PathVariable int order_id) {
		System.out.println("in delete order " + order_id);
		Optional<Order> optional = dao.findById(order_id);
		dao.deleteById(order_id);
		return new ResponseEntity<>("order rec deleted with ID " + order_id, HttpStatus.OK);

	}

}
