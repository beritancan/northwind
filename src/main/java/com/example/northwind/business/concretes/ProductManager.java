package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		
		//business logic
		return productRepository.findAll();
	}
	
	@Override
	public Product getById(int id) {
		Product productToFind = productRepository.findById(id)
				.orElseThrow(()-> new Exception("No product with id: "+ product.getById()));
		if (productToFind == null) {
			return null;
		}
		return productToFind;
	}
	
	@Override
	public Product add (Product product) {
		System.out.println(product.getProductName());
		if(product.getProductName().length()<2) {
			System.out.println(" En az 2 karakterden oluşan bir ürün ismi girmelisiniz!");	
			return null;
		}
		else {
			return productRepository.save(product) ;
		}	
	}
	
	@Override		
	public ResponseEntity<Product> update(Product product) throws Exception 
		{
		Product productToUpdate = productRepository.findById(product.getId())
					.orElseThrow(()-> new Exception("No product with id: "+ product.getId()));
			
		productToUpdate.setProductName(product.getProductName());
		
			Product updatedProduct= productRepository.save(productToUpdate);
			
			return ResponseEntity.ok(updatedProduct);
		}
	
	@Override
	public Map<String, Boolean> delete( Product product) throws Exception {
		Product productDelete = productRepository.findById(product.getId())
		    .orElseThrow(()-> new Exception("No product with id: " + product.getId()));
		    
		    productRepository.delete(productDelete);
		    Map<String, Boolean> response = new HashMap <>();
		    response.put("Silindi", Boolean.TRUE);
	        return response;	
	  }



	

	}

