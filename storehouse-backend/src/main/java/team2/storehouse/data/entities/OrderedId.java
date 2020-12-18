package team2.storehouse.data.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderedId implements Serializable {

    private Long productId;

    private Long commandId;

    public OrderedId() {
    }

    public OrderedId(Long productId, Long commandId) {
        this.productId = productId;
        this.commandId = commandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedId orderedId = (OrderedId) o;
        return Objects.equals(productId, orderedId.productId) && Objects.equals(commandId, orderedId.commandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, commandId);
    }
}
