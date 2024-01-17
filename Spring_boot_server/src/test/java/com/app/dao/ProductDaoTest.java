package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Category;
import com.app.entities.Employee;
import com.app.entities.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class ProductDaoTest {
	// depcy
	@Autowired
	private ProductDao dao;

	private Category cat;

	@Test
	void testSaveProduct() {
		List<Product> list = List.of(
				new Product("Fan", "is a fan ! ", cat.ELECTRONICS, 1200, 40, LocalDate.parse("2030-10-20")),
				new Product("Plane", "is a plane ! ", cat.TOYS, 150, 400, LocalDate.parse("2030-10-20")),
				new Product("Programming", "is  fun ! ", cat.BOOKS, 780, 70, LocalDate.parse("2040-10-20")),
				new Product("Gaming", "is more fun ! ", cat.BOOKS, 1320, 20, LocalDate.parse("2040-10-20")));
		List<Product> list2 = dao.saveAll(list);
		assertEquals(4, list2.size());
	}

}
