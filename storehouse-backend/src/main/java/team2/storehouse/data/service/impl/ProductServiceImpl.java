package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.PlaceDao;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.dao.SubcategoryDao;
import team2.storehouse.data.dao.VendorDao;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.*;
import team2.storehouse.data.service.ProductService;
import team2.storehouse.exceptions.UserNotFoundException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    PlaceDao placeDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    SubcategoryDao subcategoryDao;

    @Autowired
    VendorDao vendorDao;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public ProductDto addProduct(ProductDto productDto, Long placeId) {
        Product product = modelMapper.map(productDto,Product.class);
        Subcategory subcategory = subcategoryDao.findByName(productDto.getSubcategoryName()).orElseThrow(() -> new RuntimeException("subcategory " + productDto.getSubcategoryName() + " not found"));
        product.setSubcategory(subcategory);
        Vendor vendor = vendorDao.findById(productDto.getVendorId()).orElseThrow(() -> new RuntimeException("vendor " + productDto.getVendorId() + " not found"));
        product.setVendor(vendor);
        Place place = placeDao.findById(placeId).orElseThrow(() -> new RuntimeException("place " + placeId + "not found"));
        product.setPlace(place);
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

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productDao.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setSize(productDto.getSize());
        Vendor vendor = vendorDao.findById(productDto.getVendorId()).orElseThrow(() -> new RuntimeException("vendor " + productDto.getVendorId() + " not found"));
        product.setVendor(vendor);
        Subcategory subcategory = subcategoryDao.findByName(productDto.getSubcategoryName()).orElseThrow(() -> new RuntimeException("category " + productDto.getSubcategoryName() + " not found"));
        product.setSubcategory(subcategory);
        return modelMapper.map(productDao.save(product), ProductDto.class);
    }

    @Override
    public ProductDto updateQuantity(Long id, int quantity) {
        Product product = productDao.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        if(product.getStock() + quantity < 0) {
            throw new RuntimeException("the stock for the product " + product.getName() + " is not enough");
        }
        if(product.getStock() + quantity > 50) {
            throw new RuntimeException("there is no enough space");
        }
        product.setStock(product.getStock() + quantity);
        return modelMapper.map(productDao.save(product), ProductDto.class);
    }
}
