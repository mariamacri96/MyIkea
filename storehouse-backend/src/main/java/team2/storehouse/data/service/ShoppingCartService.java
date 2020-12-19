package team2.storehouse.data.service;
import team2.storehouse.data.dto.ShoppingCartDto;
import team2.storehouse.data.entities.ShoppingCart;

import java.util.List;
public interface ShoppingCartService {
    ShoppingCartDto addShoppingCart(ShoppingCartDto shoppingCart);
    List<ShoppingCartDto> getShoppingCarts();
}
