package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Product;

import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String name);
}
