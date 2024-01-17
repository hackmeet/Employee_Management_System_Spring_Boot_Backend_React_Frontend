package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.dao.ProductDao;
import com.app.entities.Category;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	// depcy
	@Autowired
	private ProductDao proDao;

//	5.1 Get all products
//	http://localhost:8080/products
//	Method : GET

	@Override
	public List<Product> getAllProducts() {

		return proDao.findAll();
	}

//	5.2 Add new product
//	http://localhost:8080/products
//	method : POST

	@Override
	public Product addNewProduct(Product transientPro) {
		// CrudRepository method : T save (T entity)
		return proDao.save(transientPro);
	}// rets DETACHED product to the caller

	// 5.3 Get Product by it's id
	// http://localhost:8080/products/{productId}
	// Method : GET

	@Override
	public Product getProductDetailsById(Long productId) {
		// TODO Auto-generated method stub
		return proDao.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!!!"));
	}

	// in case of valid id : rets DETACHED emp
	// in case of invalid id : throws Custom exc

	// 5.4 Get Products by it's category
	// http://localhost:8080/products/category/{categoryName}
	// Method : GET
	// Hint : List<Product> findByCategory(Category cat)

	@Override
	public List<Product> getProductDetailsByCategory(Category proCat) {
		// TODO Auto-generated method stub
		return proDao.findByCategory(proCat);
	}

//	5.5 Update product details
//	http://localhost:8080/products
//	Method : PUT
	@Override
	public Product updateProduct(Product detachedProduct) {
		// chk if pro exists
		if (proDao.existsById(detachedProduct.getId())) {// select
			// exists --update
			return proDao.save(detachedProduct);
		}
		throw new ResourceNotFoundException("Invalid emp id !!!!");
	}

//	5.6 Delete Product details
//	http://localhost:8080/products/{productId}
//	Method : DELETE
	@Override
	public String deleteProduct(Long productId) {
		if(proDao.existsById(productId)) {
			proDao.deleteById(productId);
			System.out.println("Product deleted !! ");
			return "deleted product details...";
		}
		return "deletion of product details failed !!!!!";
	}

}
