package team2.storehouse.data.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ShoppingCartDao;
import team2.storehouse.data.dto.ShoppingCartDto;
import team2.storehouse.data.entities.ShoppingCart;
import team2.storehouse.data.service.ShoppingCartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    ShoppingCartDao shoppingCartDao;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ShoppingCartDto addShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart1 = modelMapper.map(shoppingCartDto,ShoppingCart.class);
        return modelMapper.map(shoppingCartDao.save(shoppingCart1),ShoppingCartDto.class);
    }

    @Override
    public List<ShoppingCartDto> getShoppingCarts() {
        List<ShoppingCart> shoppingCarts =  shoppingCartDao.findAll();
        return  shoppingCarts.stream()
                .map(shoppingCart -> modelMapper
                        .map(shoppingCart, ShoppingCartDto.class))
                .collect(Collectors.toList());
    }
}
