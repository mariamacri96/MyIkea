package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ProductDto>> all() {
        List<ProductDto> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }


    @GetMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @PostMapping("/product/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.save(productDto));
    }

    @PostMapping("/product/update")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.update(productDto));
    }

    @DeleteMapping("/product/delete")
    public ResponseEntity delete (@RequestParam(name = "id") Long id) {
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/product/updatequantity/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<ProductDto> updateQuantity(@PathVariable("id") Long id,
                                                     @RequestParam(name="quantity", defaultValue = "0") int quantity) {
        return ResponseEntity.ok(productService.updateQuantity(id, quantity));
    }

}
