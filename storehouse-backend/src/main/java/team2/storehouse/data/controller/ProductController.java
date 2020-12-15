package team2.storehouse.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.dto.ProfileDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.service.ProductService;
import team2.storehouse.data.service.UserService;
import team2.storehouse.data.service.impl.LogIn;

import java.util.List;

@Controller
@RequestMapping("piece")
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>>all(){
        List<ProductDto> products= productService.getProducts();
        return ResponseEntity.ok(products);
    }


}
