package team2.storehouse.data.service;

import team2.storehouse.data.entities.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getProducts();
}
