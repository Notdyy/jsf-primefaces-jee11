package my.example.jakarta.service;

import java.util.List;

import my.example.jakarta.entities.Product;

public interface ProductServiceable {

	void saveProduct(Product product);

	List<Product> getAllProducts();
	
	void updateProduct(Product product);

	void deleteProduct(Product product);

}
