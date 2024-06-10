package com.walmart.exam.product;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product", uniqueConstraints = {@UniqueConstraint(columnNames = {"productKey"})})
public class Product {
	
	@Id
	@GeneratedValue
	private Integer id;
	
    @Column(nullable = false)
	private String productKey;
    
	@Basic
	private String name;
	private String description;
	private Double price;
	private String imageUrl;
}
