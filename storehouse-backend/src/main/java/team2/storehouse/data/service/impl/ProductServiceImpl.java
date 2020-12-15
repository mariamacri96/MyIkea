package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.User;
import team2.storehouse.data.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto,Product.class);
        return modelMapper.map(productDao.save(product),ProductDto.class);

    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products =  productDao.findAll();
        return  products.stream()
                .map(product -> modelMapper
                        .map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
}
