package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Subcategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryDto implements Serializable {

    private Long id;

    private String name;

    private List<Subcategory> subcategories = new ArrayList<Subcategory>();

    public List<Subcategory> getSubcategories() {

        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {

        this.subcategories = subcategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
