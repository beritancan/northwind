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

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/v1")
public class CategoriesController {

	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> getAll(){
		return categoryService.getAll();
		
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category getById() {
		Category categoryToFind =  categoryService.findById(category.getCategoryId())
				.orElseThrow(()-> new Exception("No product with id: "+  category.getCategoryId()));
		if (categoryToFind == null) {
			return null;
		}
		return categoryToFind;			
	}
	
	@PostMapping("/categories")
	public Category add (@RequestBody Category category) {
		System.out.println(category.getCategoryId());
		System.out.println(product.getProductId());
		if(product.getProductId().count>10) {
			System.out.println("Bir kategoride en fazla 10 adet ürün olabilir");	
			return null;
		}
		else {
			return categoryService.add(category) ;
		}	
	}
	
	@PutMapping("/categories/{id}") 
	public ResponseEntity<Category> update(@RequestBody Category category) throws Exception {
	Category categoryToUpdate = categoryService.getById(category.getCategoryId())
				.orElseThrow(()-> new Exception("No category with id: "+ category.getCategoryId()));
		
	categoryToUpdate.setCategoryName(category.getCategoryName());
	
	Category updatedCategory= categoryService.update(categoryToUpdate);
		
		return ResponseEntity.ok(updatedCategory);
	}
	
	@DeleteMapping("categories/{id}")
	public Map<String, Boolean> delete(@PathVariable Category category) throws Exception {
		Category categoryDelete = categoryService.getById(category.getCategoryId())
		    .orElseThrow(()-> new Exception("No category with id: " + category.getCategoryId()));
		    
		categoryService.delete(categoryDelete);
		    Map<String, Boolean> response = new HashMap <>();
		    response.put("Silindi", Boolean.TRUE);
	        return response;	
	  }
	
	
}
