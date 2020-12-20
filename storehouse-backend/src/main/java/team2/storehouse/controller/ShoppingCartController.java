package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.ShoppingCartDto;
import team2.storehouse.data.service.ShoppingCartService;

@Controller
@RequestMapping("storehouse")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/shoppingcart/add")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShoppingCartDto> addProductInShoppingCart(@RequestParam(name = "userId") Long userId,
                                                                    @RequestParam(name = "productId") Long productId,
                                                                    @RequestParam(name = "quantity") int quantity) {
        return ResponseEntity.ok(shoppingCartService.addProduct(userId, productId, quantity));
    }

    @DeleteMapping("/shoppingcart/delete")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ShoppingCartDto> deleteProductInShoppingCart(@RequestParam(name = "userId") Long userId,
                                                                       @RequestParam(name = "productId") Long productId) {
        return ResponseEntity.ok(shoppingCartService.deleteProduct(userId, productId));
    }

}
