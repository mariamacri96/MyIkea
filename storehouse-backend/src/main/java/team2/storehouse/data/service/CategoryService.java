package team2.storehouse.data.service;

import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.dto.SubcategoryDto;


import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories();
    List<SubcategoryDto> getSubCategoriesByIdCategory(Long id);
}
