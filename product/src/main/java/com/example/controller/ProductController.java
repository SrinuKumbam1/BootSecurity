package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Coupon;
import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/productapi")
@CrossOrigin(maxAge = 30000)
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public ResponseEntity<Product> getProductById(@RequestParam long id){
		Product products = productService.getProductById(id);
		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
//		String couponURL = "http://localhost:8080/couponapi/coupons";
		
		RestTemplate template = new RestTemplate();
//		Coupon coupon = template.getForObject(couponURL+"?couponCode="+product.getCouponCode(), Coupon.class);
//		product.setPrice(product.getPrice() - coupon.getDiscount());
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);
		
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/products")
	public void deleteProduct(@RequestParam long id){
		productService.deleteProduct(id);
		
	}
}
