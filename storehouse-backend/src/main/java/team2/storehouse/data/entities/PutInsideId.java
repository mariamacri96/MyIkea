package team2.storehouse.data.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PutInsideId implements Serializable {

    private Long productId;

    private Long shoppingCartId;

    public PutInsideId() {
    }

    public PutInsideId(Long productId, Long shoppingCartId) {
        this.productId = productId;
        this.shoppingCartId = shoppingCartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutInsideId that = (PutInsideId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(shoppingCartId, that.shoppingCartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, shoppingCartId);
    }
}
