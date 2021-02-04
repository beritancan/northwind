package com.example.northwind.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {
	
	@Autowired
	IProductService productService; //api businessı çağırdı o yüzden productservice i return ettik
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return productService.getAll();
		
	}
	
	@GetMapping("/products/{productId}")
	public Product getById(int id) throws Exception {
		
		Product productToFind = productService.findById(product.getId())
				.orElseThrow(()-> new Exception("No product with id: "+ product.getId()));
		if (productToFind == null) {
			return null;
		}
		return productToFind;
		
	}
	
	@PostMapping("/products")
	public Product add (@RequestBody Product product) {
		System.out.println(product.getProductName());
		if(product.getProductName().length()<2) {
			System.out.println(" En az 2 karakterden oluşan bir ürün ismi girmelisiniz!");	
			return null;
		}
		else {
			return productService.add(product) ;
		}	
	}
	
	@PutMapping("/products/{id}") 
	public ResponseEntity<Product> update(@RequestBody Product product) throws Exception {
	Product productToUpdate = productService.getById(product.getId())
				.orElseThrow(()-> new Exception("No product with id: "+ product.getId()));
		 
	productToUpdate.setProductName(product.getProductName());
	
		Product updatedProduct = productService.update(productToUpdate);
		
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("products/{id}")
	public Map<String, Boolean> delete(@PathVariable Product product) throws Exception {
		Product productDelete = productService.getById(product.getId())
				.orElseThrow(()-> new Exception("No product with id: " + product.getId()));
			    
			    productService.delete(productDelete);
			    Map<String, Boolean> response = new HashMap <>();
			    response.put("Silindi", Boolean.TRUE);
		        return response;	
		  }
	
	

}
