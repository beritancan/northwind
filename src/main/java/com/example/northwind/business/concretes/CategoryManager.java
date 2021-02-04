package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Product;


@Service
public class CategoryManager implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	
	public CategoryManager(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Category> getAll() {
		
		return categoryRepository.findAll();
		
	}

	@Override
	public Category getById(int id) {
		Category categoryToFind = categoryRepository.findById(id)
				.orElseThrow(()-> new Exception("No product with id: "+ category.getId()));
		if (categoryToFind == null) {
			return null;
		}
		return categoryToFind;
	}

	@Override
	public Category add(Category category) {
		System.out.println(category.getCategoryId());
		System.out.println(product.getProductId());
		if(product.getProductId().count()>10) {
			System.out.println("Bir kategoride en fazla 10 adet ürün olabilir");	
		return null;
	} else {
		return categoryRepository.save(category);
}
		

	@Override
	public ResponseEntity<Category> update(Category category) throws Exception {
		Category  categoryToUpdate = categoryRepository.findById(category.getCategoryId())
				.orElseThrow(()-> new Exception("No product with id: "+ category.getCategoryId())); //// BURAYA BAKKKK
		
		categoryToUpdate.setCategoryName(category.getCategoryName());
	
		Category updatedCategory= categoryRepository.save(categoryToUpdate);
		
		return ResponseEntity.ok(updatedCategory);
	}

	@Override
	public Map<String, Boolean> delete(Category category) throws Exception {
		Category categoryDelete = categoryRepository.findById(category.getCategoryId())
			    .orElseThrow(()-> new Exception("No category with id: " + category.getCategoryId()));
			    
		categoryRepository.delete(categoryDelete);
			    Map<String, Boolean> response = new HashMap <>();
			    response.put("Silindi", Boolean.TRUE);
		        return response;	
	}

}