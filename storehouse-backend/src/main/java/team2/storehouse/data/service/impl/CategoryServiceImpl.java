package team2.storehouse.data.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import team2.storehouse.data.dao.CategoryDao;
import team2.storehouse.data.dao.SubcategoryDao;
import team2.storehouse.data.dto.SubcategoryDto;
import team2.storehouse.data.dto.CategoryDto;
import team2.storehouse.data.entities.Category;
import team2.storehouse.data.entities.Subcategory;
import team2.storehouse.data.service.CategoryService;

import java.util.ArrayList;
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

    @Override
    public List<SubcategoryDto> getSubCategoriesByIdCategory(Long id){
        //use of specification
        List<Subcategory> subcategories= subcategoryDao.findAll( SubcategoryDao.findByCategory(id));
        return subcategories.stream()
                .map(subcategory -> modelMapper
                        .map(subcategory, SubcategoryDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public SubcategoryDto getSubcategory(String name) {
        return modelMapper.map(subcategoryDao.findByName(name).orElseThrow(
                () -> new RuntimeException("subcategory not found")), SubcategoryDto.class);
    }

    @Override
    public List<String> getSubCategoriesName() {
        List<Subcategory> subcategories= subcategoryDao.findAll();
        List<String> names = new ArrayList<>();
        for(Subcategory cat : subcategories) {
            names.add(cat.getName());
        }
        return names;
    }

    public Page<CategoryDto> getCategoriesPageble(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> pageResult = categoryDao.findAll(pageRequest);
        List<CategoryDto> categories = pageResult
                .stream()
                .map(category -> modelMapper
                        .map(category, CategoryDto.class))
                .collect(Collectors.toList());

        return new PageImpl<CategoryDto>(categories, pageRequest, pageResult.getTotalElements());
    }

}
