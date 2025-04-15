package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Category;
import com.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	 private CategoryService categService;
	
	@GetMapping
	 public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	     return categService.getAllCategories(page, size);
	 }
	
	@PostMapping
	 public Category createCategory(@RequestBody Category category) {
	     return categService.createCategory(category);
	 }

	 @GetMapping("/{categID}")
	 public ResponseEntity<Category> getCategoryById(@PathVariable("categID") int categID) {
	     Optional<Category> category = categService.getCategoryById(categID);
	     return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 }

	 @PutMapping("/{categID}")
	 public ResponseEntity<Category> updateCategory(@PathVariable("categID") int categID, @RequestBody Category categoryDetails) {
	     Category updatedCategory = categService.updateCategory(categID, categoryDetails);
	     return ResponseEntity.ok(updatedCategory);
	 }

	 @DeleteMapping("/{categID}")
	 public ResponseEntity<String> deleteCategory(@PathVariable("categID") int categID) {
		 categService.deleteCategory(categID);
	     return ResponseEntity.noContent().build();
	 }

}
