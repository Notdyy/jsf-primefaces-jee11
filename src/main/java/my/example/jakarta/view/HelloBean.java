package my.example.jakarta.view;

import java.io.Serial;
import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import my.example.jakarta.model.HelloModel;
import my.example.jakarta.service.HelloServiceable;


@Slf4j
@Getter
@Setter
@Named
@ViewScoped
public class HelloBean implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;
	
	private final HelloServiceable helloService;
	
	@Inject
	public HelloBean(HelloServiceable helloService) {
		this.helloService = helloService;
	}
	
	private HelloModel hello;
	
	@PostConstruct
	public void init() {
		log.debug("init HelloBean");
		this.hello = this.helloService.sayHello("Hello from PrimeFaces 15 + Jakarta EE 11!");
	}

}
