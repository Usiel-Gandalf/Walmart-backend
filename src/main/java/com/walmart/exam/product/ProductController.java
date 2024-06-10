package com.walmart.exam.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.exam.utils.ProductResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@GetMapping("getallproducts")
	public ResponseEntity<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("getproductbyid/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}
	
	@PostMapping("createproduct")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("updateproduct")
	public ResponseEntity<ProductResponse> updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("deleteproductbyid/{id}")
	public ResponseEntity<ProductResponse> deleteProductById(@PathVariable Integer id) {
		return productService.deleteProductById(id);
	}
}
