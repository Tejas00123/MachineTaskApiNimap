package com.mt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mt.entity.Product;
import com.mt.repository.IProductRepo;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService {
	@Autowired
	private IProductRepo repo;
  
	@Override
	public Page<Product> getAllProducts(Pageable pageable) {
		Page<Product> page = repo.findAll(pageable);
		return page;
	}

	@Override
	public Product createNewProduct(Product product) {
		Product savedProduct = repo.save(product);
		return savedProduct;
	}

	@Override
	public Product getProductById(Long id) {
		Product product = repo.findById(id).orElseThrow(()->new RuntimeException("Id does not exists..."));
		return product;
	}

	@Override
	public Product updateProductById(Long id, Product upDateProduct) {
		Product existingProduct = repo.findById(id).orElseThrow(()->new RuntimeException("Id does not exists..."));
        existingProduct.setName(upDateProduct.getName());
        existingProduct.setPrice(upDateProduct.getPrice());
        existingProduct.setCategory(upDateProduct.getCategory());
		return repo.save(existingProduct);
	}

	@Override
	public void deleteProductById(Long id) {
		Product product = repo.findById(id).orElseThrow(()->new RuntimeException("Id does not exists..."));
		repo.delete(product);
	}

}
