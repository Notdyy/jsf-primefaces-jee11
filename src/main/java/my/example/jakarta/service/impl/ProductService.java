package my.example.jakarta.service.impl;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import my.example.jakarta.entities.Product;
import my.example.jakarta.repository.ProductRepository;
import my.example.jakarta.service.ProductServiceable;

@Slf4j
@ApplicationScoped
public class ProductService implements ProductServiceable {

	private final ProductRepository productRepository;
	
	@Inject
	public ProductService(ProductRepository productRepository) {
		if (productRepository == null) {
			log.error("ProductRepository cannot be null");
		}
		this.productRepository = productRepository;
	}


	@Transactional
	@Override
	public void saveProduct(Product product) {
		log.info("Saving product: {}", product);
		this.productRepository.save(product);
		log.info("Product saved successfully.");
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("Retrieving all products.");
		List<Product> products = this.productRepository.findAll().toList();
		log.info("Retrieved {} products.", products.size());
		return products;
	}

	@Transactional
	@Override
	public void updateProduct(Product product) {
		log.info("Updating product with ID: {}", product.getId());
		this.productRepository.update(product);
		log.info("Product updated successfully.");
	}

	@Transactional
	@Override
	public void deleteProduct(Product product) {
		log.info("Deleting product with ID: {}", product.getId());
		this.productRepository.deleteById(product.getId());
		log.info("Product deleted successfully.");
	}

}
