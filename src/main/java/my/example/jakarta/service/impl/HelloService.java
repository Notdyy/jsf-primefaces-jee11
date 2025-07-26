package my.example.jakarta.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import my.example.jakarta.model.HelloModel;
import my.example.jakarta.service.HelloServiceable;

@Slf4j
@ApplicationScoped
public class HelloService implements HelloServiceable {

	@Override
	public HelloModel sayHello(String message) {
		try {
			log.info("sayHello called with message: {}", message);
			HelloModel model = new HelloModel();
			model.setMessage(message);
			return model;
		} finally {
			log.info("sayHello completed");
		}
	}
}
