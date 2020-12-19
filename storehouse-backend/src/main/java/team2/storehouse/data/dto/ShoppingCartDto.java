package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Product;
import team2.storehouse.data.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDto implements Serializable {
    private Long id;

    private User user;

    private List<Product> products = new ArrayList<Product>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
