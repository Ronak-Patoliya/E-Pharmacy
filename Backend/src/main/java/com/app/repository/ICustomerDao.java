package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer>{

		public Optional<Customer> findByEmailAndPassword(String email,String password);
}
