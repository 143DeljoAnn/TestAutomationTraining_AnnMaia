package com.example.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	private ProductService pService;

	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getProducts(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "price") String sortby) {
		Page<Product> pprod = pService.getProducts(page, size, sortby);
		return new ResponseEntity<Page<Product>>(pprod, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Product> createProducts(@RequestBody Product prod) {
		Product cProduct = pService.createProduct(prod);
		return new ResponseEntity<Product>(cProduct, HttpStatus.CREATED);

	}
}
