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

    @GetMapping("/products")   // works
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ProductDto>> all(){
        List<ProductDto> products= productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/product/creation")   // works
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto,
                                                    @RequestParam(name="placeId", defaultValue = "1") Long placeId,
                                                    @RequestParam(name="quantity", defaultValue = "1") int quantity) {
        productService.addProduct(productDto, placeId, quantity);
        return ResponseEntity.ok(productDto);
    }


}
