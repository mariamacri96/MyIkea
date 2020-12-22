package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/categories")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CategoryDto>> all(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

}
