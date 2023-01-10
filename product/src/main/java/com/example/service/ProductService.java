package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(long id);

	Product updateProduct(Product product);
	
	void deleteProduct(long id);
}
