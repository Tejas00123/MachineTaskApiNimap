package com.mt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.entity.Category;

public interface ICategoryRepo extends JpaRepository<Category, Long> {

}
