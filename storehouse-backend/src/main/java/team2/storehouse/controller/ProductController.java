package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ProductDto>> all(){
        List<ProductDto> products= productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/product/creation")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,
                                                    @RequestParam(name="placeId", defaultValue = "1") Long placeId) {
        productService.addProduct(productDto, placeId);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/product/update/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> update(@PathVariable("id") Long id,
                                             @RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.update(id, productDto));
    }

    @PutMapping("/product/updatequantity/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> updateQuantity(@PathVariable("id") Long id,
                                                     @RequestParam(name="quantity", defaultValue = "0") int quantity) {
        return ResponseEntity.ok(productService.updateQuantity(id, quantity));
    }

}
