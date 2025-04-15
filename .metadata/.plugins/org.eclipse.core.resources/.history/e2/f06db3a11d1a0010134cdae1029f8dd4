package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dao.CategoryRepository;
import com.model.Category;
import com.model.Product;

@Service
public class CategoryService {
	
	 @Autowired
	 private CategoryRepository categoryRepo;

	 public Page<Category> getAllCategories(int page, int size) {
	     return categoryRepo.findAll(PageRequest.of(page,size));
	 }
	 
	
//	 public Category createCategory(Category category) {
//	     return categoryRepo.save(category);
//	 }
	 
	 public Category createCategory(Category category) {
		 if (category.getProducts() != null) {
	            for (Product product : category.getProducts()) {
	                product.setCategory(category); // Important!
	            }
	        }

	        // Save the category (products will be saved because of CascadeType.ALL)
	        return categoryRepo.save(category);
	 }
	 

	 public Optional<Category> getCategoryById(int categID) {
	     return categoryRepo.findById(categID);
	 }
	 
	 
	 public Category updateCategory(int categID, Category categoryDetails) {
	     Category category = categoryRepo.findById(categID).orElseThrow(() -> new RuntimeException("Category not found"));
	     category.setCategName(categoryDetails.getCategName());
	     return categoryRepo.save(category);
	 }

	 public void deleteCategory(int categID) {
		 categoryRepo.deleteById(categID);
	 }

}
