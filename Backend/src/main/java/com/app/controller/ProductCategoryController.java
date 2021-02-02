package com.app.controller;

import java.util.List;
import java.util.Locale.Category;
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

import com.app.pojos.MedicalProduct;
import com.app.pojos.ProductCategory;
import com.app.repository.IProductCategoryDao;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class ProductCategoryController {
	


		@Autowired
		private IProductCategoryDao dao;

		public ProductCategoryController() {
			System.out.println("in ctor of " + getClass().getName());
		}

		@GetMapping
		public ResponseEntity<?> getAllCategoryDetails() {
			List<ProductCategory> categories = dao.findAll();
			return ResponseEntity.ok(categories);
		}

		@GetMapping("/{category_id}")
		public ResponseEntity<?> getCategoryDetails(@PathVariable int category_id) {
			System.out.println("in get Category dtls " + category_id);
			Optional<ProductCategory> optional = dao.findById(category_id);

			return ResponseEntity.ok(optional);
		}
		
		@PostMapping
		public ResponseEntity<?> addCategoryDetails(@RequestBody @Valid ProductCategory category) {
			return new ResponseEntity<>(dao.save(category), HttpStatus.CREATED);
		}
		
		@PutMapping("/{category_id}")
		public ResponseEntity<?> updateCategoryDetails(@PathVariable int category_id, @RequestBody ProductCategory category) {
			System.out.println("in update Category " + category_id + " " + category);
			Optional<ProductCategory> optional = dao.findById(category_id);
			ProductCategory existingCategory = optional.get();
			existingCategory.setCategoryType(category.getCategoryType());
			
				return new ResponseEntity<>(dao.save(existingCategory), HttpStatus.OK);

		}
		
		@DeleteMapping("/{category_id}")
		public ResponseEntity<?> deleteCategoryDetails(@PathVariable  int category_id) {
			System.out.println("in delete category " + category_id);
			Optional<ProductCategory> optional = dao.findById(category_id);
				dao.deleteById(category_id);
				return new ResponseEntity<>("category rec deleted with ID " + category_id, HttpStatus.OK);

		}
}
