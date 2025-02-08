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
import com.mt.entity.Product;
import com.mt.service.IProductMgmtService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
   @Autowired
   private IProductMgmtService service;
   
   @GetMapping
   public ResponseEntity<Page<Product>> showAllProducts(@RequestParam(defaultValue = "0") int page,
		                                                   @RequestParam(defaultValue = "5") int size,
		                                                   @RequestParam(defaultValue = "price") String sortBy,
		                                                   @RequestParam(defaultValue = "true") boolean ascending){
	   Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
	   Pageable pageable = PageRequest.of(page, size, sort);
	   Page<Product> allProducts = service.getAllProducts(pageable);
	   return new ResponseEntity<Page<Product>>(allProducts,HttpStatus.OK);
   }
 
   @PostMapping
    public ResponseEntity<Product> saveNewProduct(@RequestBody Product product){
    	Product newProduct = service.createNewProduct(product);
    	return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }
   
   @GetMapping("/{id}")
   public ResponseEntity<Product> findProductById(@PathVariable Long id){
	   Product product = service.getProductById(id);
	   return new ResponseEntity<Product>(product, HttpStatus.OK);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
	   Product updateProductById = service.updateProductById(id, product);
       return new ResponseEntity<Product>(updateProductById, HttpStatus.OK);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
       service.deleteProductById(id);
       return ResponseEntity.noContent().build(); // Returns 204 No Content
   }

}
