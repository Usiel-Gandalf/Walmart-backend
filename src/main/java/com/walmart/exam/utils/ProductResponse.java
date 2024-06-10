package com.walmart.exam.utils;

import java.util.List;
import java.util.Optional;

import com.walmart.exam.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
	Boolean estatus;
	String message;
	List<Product> allProducts;
	Optional<Product> product;
}
