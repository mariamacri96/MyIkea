package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Subcategory;

import javax.persistence.*;
import java.util.List;

public class SubcategoryDto {

  //  private Long idCategory;
    //private String nameCategory;
    private Long id;
    private String name;
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
