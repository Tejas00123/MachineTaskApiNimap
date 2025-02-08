package com.mt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.entity.Product;

public interface IProductRepo extends JpaRepository<Product, Long> {

}
