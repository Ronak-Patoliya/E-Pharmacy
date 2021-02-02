package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.repository.IMedicalProductDao;
import com.app.pojos.MedicalProduct;


@Service
@Transactional
public class MedicalProductService {

		@Autowired
		private IMedicalProductDao dao;
		
		
	
		public List<MedicalProduct> getAllProducts() {
			System.out.println("dao imple class " + dao.getClass().getName());
			return dao.findAll();
		}

		public Optional<MedicalProduct> getProductDetails(int pid) {
			return dao.findById(pid);
		}
}
