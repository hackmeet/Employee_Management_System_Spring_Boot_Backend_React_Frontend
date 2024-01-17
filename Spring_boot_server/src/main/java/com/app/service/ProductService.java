package com.app.service;

import java.util.List;

import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductService {

	
	List<Product> getAllProducts();

	Product addNewProduct(Product transientPro);

	Product getProductDetailsById(Long productId);
	
	List<Product> getProductDetailsByCategory(Category proCat);

	Product updateProduct(Product detachedProduct);

	String deleteProduct(Long productId);
	
}
