package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ORDERED")
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COMMAND", referencedColumnName = "ID")
    private Command command;

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

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
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
        Ordered ordered = (Ordered) o;
        return quantity == ordered.quantity && Objects.equals(id, ordered.id) && Objects.equals(product, ordered.product) && Objects.equals(command, ordered.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, command, quantity);
    }

    @Override
    public String toString() {
        return "Ordered{" +
                "id=" + id +
                ", product=" + product +
                ", command=" + command +
                ", quantity=" + quantity +
                '}';
    }
}
