package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Subcategory;
import team2.storehouse.data.entities.Vendor;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class ProductDto implements Serializable {

    private Long id;

    private String name;

    private String brand;

    private double price;

    private Subcategory subcategory;

    private Vendor vendor;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
