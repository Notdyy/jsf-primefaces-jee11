package my.example.jakarta.view;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.example.jakarta.entities.Product;
import my.example.jakarta.model.HelloModel;
import my.example.jakarta.service.HelloServiceable;
import my.example.jakarta.service.ProductServiceable;

@Slf4j
@Getter
@Setter
@Named
@ViewScoped
public class HelloBean implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Inject
	private HelloServiceable helloService;

	@Inject
	private ProductServiceable productService;

	private HelloModel hello;

	private List<Product> products;

	@PostConstruct
	public void init() {
		try {
			log.debug("init HelloBean");
			this.hello = this.helloService.sayHello("Hello from PrimeFaces 15 + Jakarta EE 11!");
			this.products = this.productService.getAllProducts();
			log.debug("End init HelloBean");
		} catch (Exception e) {
			log.error("Error during initialization: {}", e.getMessage(), e);
			throw e;
		}
	}

}
