package team2.storehouse.data.service;

import team2.storehouse.data.dto.ShoppingCartDto;

public interface ShoppingCartService {
    ShoppingCartDto getShoppingCart(Long userId);
    ShoppingCartDto addProduct(Long userId, Long productId, int quantity);
    ShoppingCartDto deleteProduct(Long userId, Long productId);
}
