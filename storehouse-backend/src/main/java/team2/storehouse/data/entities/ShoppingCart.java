package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {  // Carrello

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "shoppingCart")
    private User user;

    @ManyToMany
    @JoinTable(    // the quantity must be handled
            name = "PUT_INSIDE",
            joinColumns = @JoinColumn(name = "SHOPPING_CART", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")
    )
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products);
    }
}
