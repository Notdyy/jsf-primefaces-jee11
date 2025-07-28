package my.example.jakarta.repository;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import my.example.jakarta.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

}
