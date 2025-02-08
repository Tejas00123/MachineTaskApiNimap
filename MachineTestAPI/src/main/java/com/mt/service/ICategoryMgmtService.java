package com.mt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mt.entity.Category;

public interface ICategoryMgmtService {

	public Page<Category> getAllCategories(Pageable pageable);
	public Category createNewCategory(Category category);
	public Category getCategoryById(Long id);
	public Category updateCategoryById(Long id,Category upDateCategory);
	public void deleteCategoryById(Long id);
}
