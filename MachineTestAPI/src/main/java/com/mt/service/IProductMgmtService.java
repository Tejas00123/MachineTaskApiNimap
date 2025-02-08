package com.mt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mt.entity.Product;

public interface IProductMgmtService {

	public Page<Product> getAllProducts(Pageable pageable);
	public Product createNewProduct(Product product);
	public Product getProductById(Long id);
	public Product updateProductById(Long id,Product upDateProduct);
	public void deleteProductById(Long id);
}
