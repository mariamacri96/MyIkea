package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.CategoryDao;
import team2.storehouse.data.dao.SubcategoryDao;
import team2.storehouse.data.dto.SubcategoryDto;
import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.entities.Category;
import team2.storehouse.data.entities.Subcategory;
import team2.storehouse.data.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    SubcategoryDao subcategoryDao;

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

    public List<SubcategoryDto> getSubCategoriesByIdCategory(Long id){

        List<Subcategory> subcategories= subcategoryDao.findAll( SubcategoryDao.findByCategory(id));
        return subcategories.stream()
                .map(subcategory -> modelMapper
                        .map(subcategory, SubcategoryDto.class))
                .collect(Collectors.toList());

    }
}
