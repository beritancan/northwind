package com.example.northwind.business.abstracts;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.northwind.entities.concretes.Product;

public interface IProductService {
	
	List<Product> getAll();
	Product getById(int id) throws Exception;
	Product add(Product product);
	ResponseEntity<Product> update(Product product) throws Exception;
	Map<String, Boolean> delete(Product product) throws Exception;

	
}
