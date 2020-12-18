package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("piece")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")   // works
    public ResponseEntity<List<ProductDto>> all(){
        List<ProductDto> products= productService.getProducts();
        return ResponseEntity.ok(products);
    }


}
