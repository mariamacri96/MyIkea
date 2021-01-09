package team2.storehouse.data.service;

import org.springframework.data.jpa.domain.Specification;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Place;
import team2.storehouse.data.entities.Product;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto product);
    ProductDto update(ProductDto productDto);
    List<ProductDto> getProducts();
    ProductDto findProductById(Long id);
    ProductDto findProductByName(String name);
    ProductDto updateQuantity(Long id, int quantity);
    List<ProductDto> findProductBySubcategory(Long id);

    void delete(Long id);
}
