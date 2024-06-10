package com.walmart.exam.product;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.walmart.exam.utils.ProductResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ResponseEntity<ProductResponse> getAllProducts() {
		List<Product> allProducts = productRepository.findAll();
		
		ProductResponse productResponse = ProductResponse.builder()
				.estatus(true)
				.message("Producto encontrados exitosamente")
				.allProducts(allProducts)
				.build();
		
		return ResponseEntity.ok(productResponse);
	}
	
	public ResponseEntity<ProductResponse> getProductById(Integer id) {
		Optional<Product> product = productRepository.findById(id);
		
		 ProductResponse productResponse = ProductResponse.builder()
					.estatus(true)
					.message("Producto encontrados exitosamente")
					.product(product)
					.build();
			
			return ResponseEntity.ok(productResponse);
	}
	
	public ResponseEntity<ProductResponse> createProduct(Product product) {
		productRepository.save(product);
		
		ProductResponse productResponse = ProductResponse.builder()
				.estatus(true)
				.message("Producto registrado exitosamente")
				.build();
		
		return ResponseEntity.ok(productResponse);
	}
	
	public ResponseEntity<ProductResponse> updateProduct(Product product) {
		Optional<Product> productToUpdate = productRepository.findById(product.getId());
		Product productUpdated = productToUpdate.get();
		productUpdated.setProductKey(product.getProductKey());
		productUpdated.setName(product.getName());
		productUpdated.setDescription(product.getDescription());
		productUpdated.setPrice(product.getPrice());
		productUpdated.setImageUrl(product.getImageUrl());
		
		productRepository.save(productUpdated);
		
		ProductResponse productResponse = ProductResponse.builder()
				.estatus(true)
				.message("Producto actualizado exitosamente")
				.build();
		
		return ResponseEntity.ok(productResponse);
	}
	
	public ResponseEntity<ProductResponse> deleteProductById(Integer id) {
		productRepository.deleteById(id);
		
		ProductResponse productResponse = ProductResponse.builder()
				.estatus(true)
				.message("Producto eliminado exitosamente")
				.build();
		
		return ResponseEntity.ok(productResponse);
	}
}
