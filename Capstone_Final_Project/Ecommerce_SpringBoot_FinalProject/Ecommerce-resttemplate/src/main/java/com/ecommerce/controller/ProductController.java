package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
    	List<Product> products = productService.searchProducts(keyword);
        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No products found for keyword: " + keyword);
        }
        return products;
    }

    @PostMapping("/buy/{id}")
    public Product buyProduct(@PathVariable Long id, @RequestBody Product request) {
    	 int quantity = request.getQuantity();

    	    if (quantity <= 0) {
    	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantity must be greater than 0.");
    	    }

    	    Product product = productService.buyProduct(id, quantity);
    	    if (product == null) {
    	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with ID " + id + " not found.");
    	    }

    	    return product;
    }
}
