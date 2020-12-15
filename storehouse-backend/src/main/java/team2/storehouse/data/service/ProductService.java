package team2.storehouse.data.service;

import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Product;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto product);
   List<ProductDto> getProducts();
}
