package com.example.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepo;

	@PostConstruct
	void met() {
		Pageable pageable = PageRequest.of(2, 2, Sort.by("price").descending());
		Page<Product> pproduct = pRepo.findByNameContaining("Prod", pageable);

		// iterate and display products
		pproduct.forEach(System.out::println);// Method reference0'
	}

	public Page<Product> getProducts(int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

		return pRepo.findAll(pageable);

	}

	public Product createProduct(Product prod) {
		return pRepo.save(prod);

	}
}
