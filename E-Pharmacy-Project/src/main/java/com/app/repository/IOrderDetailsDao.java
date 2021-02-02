package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.OrderDetails;

public interface IOrderDetailsDao extends JpaRepository<OrderDetails, Integer> {

}
