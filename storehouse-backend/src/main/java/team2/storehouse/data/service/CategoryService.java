package team2.storehouse.data.service;

import org.springframework.data.domain.Page;
import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.dto.SubcategoryDto;


import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
    List<SubcategoryDto> getSubCategoriesByIdCategory(Long id);
    List<String> getSubCategoriesName();
    SubcategoryDto getSubcategory(String name);
    Page<CategoryDto> getCategoriesPageble(int page, int size) ;

}


