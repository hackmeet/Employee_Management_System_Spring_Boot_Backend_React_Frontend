package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Category;
import com.app.entities.Employee;
import com.app.entities.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	// depcy
	@Autowired
	private ProductService proService;

	public ProductController() {
		System.out.println("in def ctor of " + getClass());
	}

	// URL : http://host:port/products, method : GET
	// get all products
	@GetMapping
	public List<Product> getAllProducts() {
		System.out.println("in get products");
		return proService.getAllProducts();
	}

	// URL : http://host:port/products, method : POST
	// add new product details
	@PostMapping
	public Product addNewProduct(@RequestBody Product transientProduct) {
		System.out.println("in add new producr " + transientProduct);
		return proService.addNewProduct(transientProduct);
	}

	// URL : http://host:port/product/{productId}, method : GET
	// get pro details by it's id
	@GetMapping("/{productId}")
	// path variable method level - for biding product
	public Product getProductDetailsById(@PathVariable Long productId) {
		System.out.println("in get emp " + productId);
		return proService.getProductDetailsById(productId);
	}
	
	// URL : http://host:port/product/{proCat}, method : GET
	// get pro details by it's category
	@GetMapping("/category/{proCat}")
	// path variable method level - for binding product
	public List<Product> getProductDetailsByCategory(@PathVariable Category proCat) {
		System.out.println("in get product " +  proCat);
		return proService.getProductDetailsByCategory(proCat);
	}
	
	// URL : http://host:port/product, method : PUT
	// COMPLETE updation of pro details
	@PutMapping
	public Product updateProduct(@RequestBody Product detachedPro) {
		System.out.println("in update product " + detachedPro);
		return proService.updateProduct(detachedPro);
	}
	
	// URL : http://host:port/product/{productId}, method : DELETE
	// delete product details by id
	@DeleteMapping("/{productId}")
	public String deleteProductDetails(@PathVariable Long productId)
	{
		System.out.println("in del product "+productId);
		return proService.deleteProduct(productId);
	}
	
	
}
