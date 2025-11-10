package my.example.jakarta.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.Getter;

@ApplicationScoped
public class EmProducer extends AbstractEmProducer{

    @Inject
    @MyExDb
    @Getter
    private EntityManagerFactory emf;

    @MyExDb
    @Produces
    @RequestScoped
    public EntityManager produce() {
        return this.createEntityManager();
    }

    public void dispose(@Disposes @MyExDb EntityManager em) {
        em.close();
    }
}

