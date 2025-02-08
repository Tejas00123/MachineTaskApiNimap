package com.mt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

import com.mt.entity.Category;
import com.mt.service.ICategoryMgmtService;

@RestController
@RequestMapping("/api/categories")
public class CategoaryController {
 @Autowired
  private ICategoryMgmtService service;
 
   @GetMapping
   public ResponseEntity<Page<Category>> showAllCategories(@RequestParam(defaultValue = "0") int page,
		                                                   @RequestParam(defaultValue = "5") int size,
		                                                   @RequestParam(defaultValue = "name") String sortBy,
		                                                   @RequestParam(defaultValue = "true") boolean ascending){
	   Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
	   Pageable pageable = PageRequest.of(page, size, sort);
	   Page<Category> allCategories = service.getAllCategories(pageable);
	   return new ResponseEntity<Page<Category>>(allCategories,HttpStatus.OK);
   }
 
   @PostMapping
    public ResponseEntity<Category> saveNewCategory(@RequestBody Category category){
    	Category newCategory = service.createNewCategory(category);
    	return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
    }
   
   @GetMapping("/{id}")
   public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
	   Category category = service.getCategoryById(id);
	   return new ResponseEntity<Category>(category, HttpStatus.OK);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category){
	   Category updateCategoryById = service.updateCategoryById(id, category);
       return new ResponseEntity<Category>(updateCategoryById, HttpStatus.OK);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
       service.deleteCategoryById(id);
       return ResponseEntity.noContent().build(); // Returns 204 No Content
   }

}
