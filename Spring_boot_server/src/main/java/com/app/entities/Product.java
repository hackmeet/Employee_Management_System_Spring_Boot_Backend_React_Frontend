package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
public class Product extends BaseEntity{

	@Column(length = 20, unique = true) // unique constraint
	private String name;// (unique)
	
	@Column(length = 40) 
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Category category; //(enum);
	
	
	private double price; 
	
	private int available_stock; //(int)
	
	private LocalDate expiryDate;//:LocalDate
	
	
}
