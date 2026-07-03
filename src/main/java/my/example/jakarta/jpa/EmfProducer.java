package my.example.jakarta.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManagerFactory;

@ApplicationScoped
public class EmfProducer extends AbstractEmfProducer {
	
    @MyExDb
    @ApplicationScoped
    @Produces
    public EntityManagerFactory produce() {
    	return this.createEntityManagerFactory("myPU", "myPU");

    }

}
