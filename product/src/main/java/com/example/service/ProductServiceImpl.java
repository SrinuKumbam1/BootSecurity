package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(long id) {
		
		return productRepo.findById(id).get();
	}
	
	@Override
	public Product updateProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public void deleteProduct(long id) {
		productRepo.deleteById(id);
	}

}
