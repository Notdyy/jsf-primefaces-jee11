package my.example.jakarta.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public abstract class AbstractEmProducer {
	protected abstract EntityManagerFactory getEmf();

	protected EntityManager createEntityManager() {
		return this.getEmf().createEntityManager();
	}

	protected void disposeEntityManager(EntityManager disposingEm) {
		if (disposingEm != null) {
			if (disposingEm.isOpen() && disposingEm.getTransaction().isActive()) {
				disposingEm.getTransaction().rollback();
			}

			disposingEm.close();
		}
	}
}
