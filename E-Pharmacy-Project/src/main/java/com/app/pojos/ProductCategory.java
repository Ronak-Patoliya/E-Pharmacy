package com.app.pojos;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="product_category")

public class ProductCategory {
		@Id
		@Column(name="category_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int categoryId;
		
		@Column(name="category_type")
		private String categoryType;
		
		@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
		private List<MedicalProduct> medicalProducts;

		public int getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryType() {
			return categoryType;
		}

		public void setCategoryType(String categoryType) {
			this.categoryType = categoryType;
		}

	
		

		
		
		
}
