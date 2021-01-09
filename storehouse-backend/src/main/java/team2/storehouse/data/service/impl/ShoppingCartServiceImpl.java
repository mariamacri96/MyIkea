package team2.storehouse.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.dao.PutInsideDao;
import team2.storehouse.data.dao.ShoppingCartDao;
import team2.storehouse.data.dto.ElementDto;
import team2.storehouse.data.dto.ShoppingCartDto;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.PutInside;
import team2.storehouse.data.entities.ShoppingCart;
import team2.storehouse.data.service.ShoppingCartService;

import javax.transaction.Transactional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ShoppingCartDao shoppingCartDao;

    @Autowired
    PutInsideDao putInsideDao;

    @Override
    public ShoppingCartDto getShoppingCart(Long userId) {
        ShoppingCart shoppingCart = shoppingCartDao.findById(userId).orElseThrow(() -> new RuntimeException("shopping cart " + userId + " not found"));

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        for(PutInside put : putInsideDao.findAllByShoppingCart(shoppingCart)) {
            shoppingCartDto.getElements().add(new ElementDto(put.getProduct(), put.getQuantity()));
        }
        return shoppingCartDto;
    }

    @Transactional
    @Override
    public ShoppingCartDto addProduct(Long userId, Long productId, int quantity) {
        ShoppingCart shoppingCart = shoppingCartDao.findById(userId).orElseThrow(() -> new RuntimeException("shopping cart " + userId + " not found"));
        Product product = productDao.findById(productId).orElseThrow(() -> new RuntimeException("product " + productId + " not found"));

        if(putInsideDao.findByProductAndShoppingCart(product, shoppingCart).isPresent()) {
            PutInside putInside = putInsideDao.findByProductAndShoppingCart(product, shoppingCart).orElseThrow(()->new RuntimeException());
            putInside.setQuantity(putInside.getQuantity() + quantity);
            putInsideDao.save(putInside);
        }
        else {
            PutInside putInside = new PutInside();
            putInside.setShoppingCart(shoppingCart);
            putInside.setProduct(product);
            putInside.setQuantity(quantity);
            putInsideDao.save(putInside);
        }

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        for(PutInside put : putInsideDao.findAllByShoppingCart(shoppingCart)) {
            shoppingCartDto.getElements().add(new ElementDto(put.getProduct(), put.getQuantity()));
        }
        return shoppingCartDto;
    }

    @Transactional
    @Override
    public ShoppingCartDto deleteProduct(Long userId, Long productId) {
        ShoppingCart shoppingCart = shoppingCartDao.findById(userId).orElseThrow(() -> new RuntimeException("shopping cart " + userId + " not found"));
        Product product = productDao.findById(productId).orElseThrow(() -> new RuntimeException("product " + productId + " not found"));

        PutInside putInside = putInsideDao.findByProductAndShoppingCart(product, shoppingCart).orElseThrow(
                () -> new RuntimeException("the user " + userId + " didn't put the procuct " + productId + " in his shoppingcart"));
        putInsideDao.delete(putInside);

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        for(PutInside put : putInsideDao.findAllByShoppingCart(shoppingCart)) {
            shoppingCartDto.getElements().add(new ElementDto(put.getProduct(), put.getQuantity()));
        }
        return shoppingCartDto;
    }
}
