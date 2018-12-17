package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product getProductgetById(String productId);
	public List<Product> getProductByCategory(String categoryName);
	public List<Product> getProductByBrands(List<String> brands);
	public void addProduct(Product product);

}
