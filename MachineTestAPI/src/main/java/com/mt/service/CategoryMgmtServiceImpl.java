package com.mt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mt.entity.Category;
import com.mt.repository.ICategoryRepo;

@Service
public class CategoryMgmtServiceImpl implements ICategoryMgmtService {

	@Autowired
	private ICategoryRepo repo;
	
	@Override
	public Page<Category> getAllCategories(Pageable pageable) {
		Page<Category> page = repo.findAll(pageable);
		return page;
	}

	@Override
	public Category createNewCategory(Category category) {
	    Category saved = repo.save(category);
		return saved;
	}

	@Override
	public Category getCategoryById(Long id) {
		Category category = repo.findById(id).orElseThrow(()->new RuntimeException("Id does not exists..."));
	    return category;
	}

	@Override
	public Category updateCategoryById(Long id, Category upDateCategory) {
		// Check if the category exists
		Category existingCategory = repo.findById(id).orElseThrow(()->new RuntimeException("Id does not exists..."));
		// Update category properties
		existingCategory.setName(upDateCategory.getName());
		existingCategory.setProducts(upDateCategory.getProducts());
		// Save and return the updated category
		return repo.save(existingCategory);
	}

	@Override
	public void deleteCategoryById(Long id) {
		// Check if the category exists
		Category category = repo.findById(id).orElseThrow(()->new RuntimeException("Id does not exists..."));
		//delete category
		repo.delete(category);
		return;
	}

	
}
