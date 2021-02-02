package com.app.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Customer;
import com.app.pojos.MedicalProduct;






public interface IMedicalProductDao extends JpaRepository<MedicalProduct, Integer>
{
	

	@Query("select p from MedicalProduct p where p.category=20")
	public List<MedicalProduct> findByCategory();
 public List<MedicalProduct> findByName(String name);


}
