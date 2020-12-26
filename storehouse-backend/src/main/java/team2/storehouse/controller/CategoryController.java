package team2.storehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.dto.SubcategoryDto;
import team2.storehouse.data.dto.UserDto;
import team2.storehouse.data.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("storehouse")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("/categories") //work
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CategoryDto>> all(){
        return ResponseEntity.ok(categoryService.getCategories());
    }


    @GetMapping("/categories/{id}") //work try with localhost:8080/storehouse/categories/3 in postman
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<SubcategoryDto>> getSubCategoriesByIdCategory(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getSubCategoriesByIdCategory(id));
    }

}
