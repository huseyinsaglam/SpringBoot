package com.example.demo.controller;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
@RequestMapping("/products")

//@RestController
//@Path("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	//@Path("/hs")
	public String defaultPage(Model model)
	{
		List<Product > products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}
	

	@RequestMapping("/all")
	//@Path("/all")
	public String getAllProducts(Model model)
	{
		List<Product > products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping("/product")
	//@Path("/product")
	public String getProductById(@RequestParam(name="id") String productId , Model model)
	{
	  Product product =	productService.getProductgetById(productId);
	  model.addAttribute("product", product);
	  return "productDetail";
	}
	
	@RequestMapping("/category/{categoryName}")
	//@Path("/category/{categoryName}")
	public String listProductsByCategoryNamed(@PathVariable(name = "categoryName") String categoryName, Model model) {
		List<Product> productss = productService.getProductByCategory(categoryName);
		model.addAttribute("products", productss);
		return "productList";
	}

	
	// // http://localhost:8080/SpringMVCWeek3/products/brand/brands=apple,google,samsung,
	@RequestMapping("/brand/{brands}")
	//@Path("/brand/{brands}")
	public String listProductsByCategoryBrands(@MatrixVariable(pathVar = "brands") List<String> brands, Model model) {
		List<Product> products = productService.getProductByBrands(brands);
		model.addAttribute("products", products);
		return "productList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	//JSp sayfasindaki modelAttribute ile ayni isimde olmalidi! yoksa exception verir!
	//@GET
	//@Path("/add")
	
	public String addProductPage(@ModelAttribute("newProduct") Product productToAdded) {
		System.out.println("addProductPage#get invoked!");
		productToAdded.setDescription("aciklama kismi....");
		productToAdded.setCategory("laptop");
		return "productAdd";
	
	}
	
	
	// Bu metodumuzda Arrays s�n�f�m�z�n aslist() metodu yard�m�yla bir liste yap�s�na aktarabiliriz. 
	// �rnegimiz == http://teknokafe.net/2017/09/07/arrays-aslist-metodu-ile-diziyi-liste-yapisina-kopyalama/
	@ModelAttribute("manufacturerList")
	public List<String> prepareManufacturers() {
		System.out.println("prepareManufacturers#invoked!");
		return Arrays.asList("Apple","Samsung","Dell","Google","Sony");
	}
	

	@ModelAttribute("categoryList")
	public List<String> prepareCategories() {
		System.out.println("categoryList#invoked!");
		return Arrays.asList("Tablet","Laptop","TV","SmartPhone");
	}
	
	
	@ModelAttribute("conditionsMap")
	public Map<String , String> prepareConditions() {
		System.out.println("prepareConditions#invoked!");
		Map<String, String> conditions = new LinkedHashMap<>();
		conditions.put("new", "New");
		conditions.put("old", "Old");
		conditions.put("refurbished", "Refurbished");
		return conditions;
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@POST
	//@Path("/add")
	public String addProductPageSubmit(@ModelAttribute("newProduct") Product productToAdded) {
	productService.addProduct(productToAdded);
		return "redirect:/products";
	}
	
	

}
