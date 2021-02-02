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

import com.app.pojos.Order;
import com.app.pojos.OrderDetails;

import com.app.repository.IOrderDetailsDao;

@RestController
@RequestMapping("/orderdetails")
@CrossOrigin
public class OrderDetailsController {
	

		@Autowired
		private IOrderDetailsDao dao;

		@GetMapping
		public ResponseEntity<?> getAllOrdersDetails() {
			List<OrderDetails> orderdetails = dao.findAll();
			return ResponseEntity.ok(orderdetails);
		}

		@GetMapping("{orderdetail_id}")
		public ResponseEntity<?> getOrdersDetails(@PathVariable int orderdetail_id) {
			Optional<OrderDetails> optional = dao.findById(orderdetail_id);

			return ResponseEntity.ok(optional);
		}
		
		@PostMapping
		public ResponseEntity<?> addOrdersDetails(@RequestBody OrderDetails o) {
			return new ResponseEntity<>(dao.save(o), HttpStatus.CREATED);
		}
		
		
//		@PutMapping("/{order_id}")
//		public ResponseEntity<?> updateOrdersDetails(@PathVariable int order_id, @RequestBody Order order) {
//			System.out.println("in update order " + order_id + " " + order);
//			Optional<Order> optional = dao.findById(order_id);
//			Order existingOrder = optional.get();
//			existingOrder.setOrderPrice(order.getOrderPrice());
//
//			return new ResponseEntity<>(dao.save(existingOrder), HttpStatus.OK);
//
//		}

		@DeleteMapping("/{orderdetail_id}")
		public ResponseEntity<?> deleteOrdersDetails(@PathVariable int orderdetail_id) {
			System.out.println("in delete order " + orderdetail_id);
			Optional<OrderDetails> optional = dao.findById(orderdetail_id);
			dao.deleteById(orderdetail_id);
			return new ResponseEntity<>("order rec deleted with ID " + orderdetail_id, HttpStatus.OK);

		}
		
		
		
		
}
