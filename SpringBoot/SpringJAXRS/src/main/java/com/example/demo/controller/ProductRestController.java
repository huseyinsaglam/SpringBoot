package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/rest")
public class ProductRestController {
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET , value="/products")
	public List<Product> getProducts()
	{
		List<Product> product1 =productService.getAllProducts();
		return product1;
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/productname")
	public List<Product> getnamelist(@RequestParam("ad") String categoryName)
	{
		List<Product> name = productService.getProductByCategory(categoryName);
		return name;
	}
	
	
}
