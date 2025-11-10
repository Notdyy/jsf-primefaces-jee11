package my.example.jakarta.jpa;

import java.util.Objects;

import jakarta.enterprise.inject.Disposes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class AbstractEmfProducer {
	
	protected EntityManagerFactory emf;

	protected EntityManagerFactory createEntityManagerFactory(String emName, String emTomcatName) {
		if (System.getProperty("catalina.home") != null) {
			emName = emTomcatName;
		}

		if (Objects.isNull(this.emf)) {
			this.emf = Persistence.createEntityManagerFactory(emName);
		}

		return this.emf;
	}

	public void dispose(@Disposes EntityManagerFactory disposingEmf) {
		disposingEmf.close();
	}

	protected static EntityManager createLocalEm(String emLocalName) {
		return Persistence.createEntityManagerFactory(emLocalName).createEntityManager();
	}

}
