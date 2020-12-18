package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<List<ProductDto>> all(){
        List<ProductDto> products= productService.getProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id){
        ProductDto productDto= productService.findProductById(id);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/products/{name}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<ProductDto> findProductById(@PathVariable String name){
        ProductDto productDto= productService.findProductByName(name);
        return ResponseEntity.ok(productDto);
    }

}
