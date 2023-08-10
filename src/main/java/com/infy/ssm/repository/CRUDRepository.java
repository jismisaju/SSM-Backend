package com.infy.ssm.repository;

import com.infy.ssm.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDRepository extends JpaRepository<Product, Integer>{
	
	
}
