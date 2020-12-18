package team2.storehouse.data.service;

import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Place;
import team2.storehouse.data.entities.Product;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto product, Place place, int quantity);
    List<ProductDto> getProducts();
    ProductDto findProductById(Long id);
    ProductDto findProductByName(String name);
}
