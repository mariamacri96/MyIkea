package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.dao.SubcategoryDao;
import team2.storehouse.data.dao.VendorDao;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.*;
import team2.storehouse.data.service.ProductService;
import team2.storehouse.exceptions.GenericException;
import team2.storehouse.exceptions.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    SubcategoryDao subcategoryDao;

    @Autowired
    VendorDao vendorDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDto addProduct(ProductDto productDto, Place place, int quantity) {
        Product product = modelMapper.map(productDto,Product.class);
        Subcategory subcategory = subcategoryDao.findByName(productDto.getSubcategoryName()).orElseThrow(() -> new GenericException("subcategory " + productDto.getSubcategoryName() + " not found"));
        product.setSubcategory(subcategory);
        Vendor vendor = vendorDao.findById(productDto.getVendorId()).orElseThrow(() -> new GenericException("vendor " + productDto.getVendorId() + " not found"));
        product.setVendor(vendor);
        product.setPlace(place);
        product.setStock(quantity);
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

    @Override
    public ProductDto findProductById(Long id) {
        Product product= productDao.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        ProductDto productDto =modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    @Override
    public ProductDto findProductByName(String name) {
        Product product= productDao.findProductByName(name).orElseThrow(() -> new UserNotFoundException(name));
        ProductDto productDto =modelMapper.map(product, ProductDto.class);
        return productDto;
    }
}
