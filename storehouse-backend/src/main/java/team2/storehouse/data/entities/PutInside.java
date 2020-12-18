package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PUT_INSIDE")
public class PutInside {

    @EmbeddedId
    private PutInsideId id;

    @ManyToOne(optional = false)
    @MapsId("productId")
    private Product product;

    @ManyToOne(optional = false)
    @MapsId("shoppingCartId")
    private ShoppingCart shoppingCart;

    private int quantity;

    public PutInsideId getId() {
        return id;
    }

    public void setId(PutInsideId id) {
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
}
