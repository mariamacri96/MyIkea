package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.CategoryDao;
import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.dto.ProductDto;
import team2.storehouse.data.entities.Category;
import team2.storehouse.data.entities.Product;
import team2.storehouse.data.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories= categoryDao.findAll();
        return categories.stream()
                .map(category -> modelMapper
                        .map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
