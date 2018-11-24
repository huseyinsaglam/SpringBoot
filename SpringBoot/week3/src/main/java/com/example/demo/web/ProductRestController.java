package com.example.demo.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.sun.research.ws.wadl.Method;

@RestController
@RequestMapping("/rest")
public class ProductRestController {
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET , value="/products")
	public ResponseEntity<List<Product>> getProducts()
	{
		List<Product> product1 =productService.getAllProducts();
		return ResponseEntity.ok(product1);
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/productname")
	public ResponseEntity<List<Product>> getnamelist(@RequestParam("ad") String categoryName)
	{
		List<Product> name = productService.getProductByCategory(categoryName);
		return ResponseEntity.ok(name);
	}
	
	
}
