package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.PlaceDao;
import team2.storehouse.data.dao.ProductDao;
import team2.storehouse.data.dao.SubcategoryDao;
import team2.storehouse.data.dao.VendorDao;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.SubcategoryDto;
import team2.storehouse.data.entities.Place;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.Subcategory;
import team2.storehouse.data.entities.Vendor;
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
    public ProductDto save(ProductDto productDto) {

        Product product = modelMapper.map(productDto,Product.class);

        Place place = placeDao.findById(product.getPlace().getId()).orElseThrow(
                () -> new RuntimeException("place " + productDto.getPlace().getId() + "not found"));
        Subcategory subcategory = subcategoryDao.findByName(productDto.getSubcategory().getName()).orElseThrow(
                () -> new RuntimeException("subcategory " + productDto.getSubcategory().getName() + "not found"));
        Vendor vendor = vendorDao.findByName(productDto.getVendor().getName()).orElseThrow(
                () -> new RuntimeException("vendor " + productDto.getVendor().getName() + " not found"));

        if(productDao.findByPlace(place).isPresent()) {
            throw new RuntimeException("the place " + place.getId() + " is not empty");
        }

        product.setPlace(place);
        product.setSubcategory(subcategory);
        product.setVendor(vendor);
        product.setPhoto(productDto.getPhoto());
        return modelMapper.map(productDao.save(product),ProductDto.class);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product product = productDao.findById(productDto.getId()).orElseThrow(
                () -> new UserNotFoundException(productDto.getId().toString()));
        Place place = placeDao.findById(product.getPlace().getId()).orElseThrow(
                () -> new RuntimeException("place " + productDto.getPlace().getId() + "not found"));
        Subcategory subcategory = subcategoryDao.findByName(productDto.getSubcategory().getName()).orElseThrow(
                () -> new RuntimeException("subcategory " + productDto.getSubcategory().getName() + "not found"));
        Vendor vendor = vendorDao.findByName(productDto.getVendor().getName()).orElseThrow(
                () -> new RuntimeException("vendor " + productDto.getVendor().getName() + " not found"));

        if(productDao.findByPlace(place).isPresent() &&
                productDao.findByPlace(place).orElseThrow(()->new UserNotFoundException("ciao")).getId() != productDto.getId()) {
            throw new RuntimeException("the place " + place.getId() + " is not empty");
        }

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setSize(productDto.getSize());
        product.setVendor(vendor);
        product.setSubcategory(subcategory);
        product.setPlace(place);
        product.setPhoto(productDto.getPhoto());

        return modelMapper.map(productDao.save(product), ProductDto.class);
    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products = productDao.findAll();
        return products.stream()
                .map(product -> modelMapper
                        .map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductById(Long id) {
        Product product = productDao.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    @Override
    public ProductDto findProductByName(String name) {
        Product product = productDao.findProductByName(name).orElseThrow(() -> new UserNotFoundException(name));
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    @Override
    public ProductDto updateQuantity(Long id, int quantity) {
        Product product = productDao.findById(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        if(quantity < 0) {
            throw new RuntimeException("the stock for the product " + product.getName() + " cannot be negative");
        }
        product.setStock(quantity);
        return modelMapper.map(productDao.save(product), ProductDto.class);
    }

    @Override
    public List<ProductDto> findProductBySubcategory(Long id ) {
        List<Product> products= productDao.findAll(ProductDao.filterBySubCategory(id));
        return products.stream()
                .map(product -> modelMapper
                        .map(product, ProductDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        productDao.deleteById(id);
    }


}
