package com.app.controller;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import javax.validation.Valid;
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
import com.app.pojos.ProductCategory;
import com.app.repository.IMedicalProductDao;
import com.app.service.MedicalProductService;

@RestController
@CrossOrigin
@RequestMapping("/medicalitems")
public class MedicalProductController {

	@Autowired
	private IMedicalProductDao dao;

	public MedicalProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping
	public ResponseEntity<?> getAllProductDetails() {
		List<MedicalProduct> medicalitems = dao.findAll();
		return ResponseEntity.ok(medicalitems);
	}

	@GetMapping("/id/{product_id}")
	public ResponseEntity<?> getProductDetails(@PathVariable int product_id) {
		System.out.println("in get product dtls " + product_id);
		Optional<MedicalProduct> optional = dao.findById(product_id);

		return ResponseEntity.ok(optional);
	}
	
	@GetMapping("/name/{product_name}")
	public ResponseEntity<?> getProductByName(@PathVariable String product_name) {
		System.out.println("in get product dtls " + product_name);
		List<MedicalProduct> optional = dao.findByName(product_name);

		return ResponseEntity.ok(optional);
	}
	
	

	@GetMapping("{categoryId}")
	public ResponseEntity<?> findByCategory(@RequestBody MedicalProduct item)
	{
		int catId=item.getCategory().getCategoryId();
		List<MedicalProduct> items=null;
		
		items=dao.findByCategory();

		return ResponseEntity.ok(items);
	}
	

	@PostMapping
	public ResponseEntity<?> addProductDetails(@RequestBody @Valid MedicalProduct p) {
		return new ResponseEntity<>(dao.save(p), HttpStatus.CREATED);
	}

	@PutMapping("/{product_id}")
	public ResponseEntity<?> updateProductDetails(@PathVariable int product_id, @RequestBody MedicalProduct product) {
		System.out.println("in update emp " + product_id + " " + product);
		Optional<MedicalProduct> optional = dao.findById(product_id);
		MedicalProduct existingProduct = optional.get();// DETACHED
		existingProduct.setName(product.getName());
		existingProduct.setId(product.getId());
		existingProduct.setUnitPrice(product.getUnitPrice());
		existingProduct.setCompany(product.getCompany());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setExpDate(product.getExpDate());
		existingProduct.setMfgDate(product.getMfgDate());
		existingProduct.setImageUrl(product.getImageUrl());
 
		return new ResponseEntity<>(dao.save(existingProduct), HttpStatus.OK);

	}

	@DeleteMapping("/{product_id}")
	public ResponseEntity<?> deleteProductDetails(@PathVariable int product_id) {
		System.out.println("in delete product " + product_id);
		Optional<MedicalProduct> optional = dao.findById(product_id);
		dao.deleteById(product_id);
		return new ResponseEntity<>("product rec deleted with ID " + product_id, HttpStatus.OK);

	}
}
