package team2.storehouse.data.service;
import team2.storehouse.data.entities.Category;
import team2.storehouse.data.dto.CategoryDto;

import java.util.List;
public interface CategoryService {
    CategoryDto addCategory(CategoryDto category);
    List<CategoryDto> getCategories();
}
