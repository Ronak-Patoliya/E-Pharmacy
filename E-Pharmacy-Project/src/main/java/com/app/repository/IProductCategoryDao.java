package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProductCategory;

public interface IProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

}
