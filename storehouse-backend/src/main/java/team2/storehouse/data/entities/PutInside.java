package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PUT_INSIDE")
public class PutInside {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SHOPPINGCART", referencedColumnName = "ID")
    private ShoppingCart shoppingCart;

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutInside putInside = (PutInside) o;
        return quantity == putInside.quantity && Objects.equals(id, putInside.id) && Objects.equals(product, putInside.product) && Objects.equals(shoppingCart, putInside.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, shoppingCart, quantity);
    }

    @Override
    public String toString() {
        return "PutInside{" +
                "id=" + id +
                ", product=" + product +
                ", shoppingCart=" + shoppingCart +
                ", quantity=" + quantity +
                '}';
    }
}
