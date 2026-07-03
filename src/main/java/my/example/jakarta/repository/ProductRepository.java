package my.example.jakarta.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import my.example.jakarta.entities.Product;

@ApplicationScoped
@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}
