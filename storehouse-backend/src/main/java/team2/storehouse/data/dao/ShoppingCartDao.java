package team2.storehouse.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team2.storehouse.data.entities.ShoppingCart;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Long> {
}
