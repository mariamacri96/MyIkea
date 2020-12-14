package team2.storehouse.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product addProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productDao.findAll();
    }
}
