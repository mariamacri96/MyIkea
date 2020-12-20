package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.PutInside;
import team2.storehouse.data.entities.ShoppingCart;

import java.util.List;
import java.util.Optional;

@Repository
public interface PutInsideDao extends JpaRepository<PutInside, Long> {
    List<PutInside> findAllByShoppingCart(ShoppingCart shoppingCart);
    Optional<PutInside> findByProductAndShoppingCart(Product product, ShoppingCart shoppingCart);
}
