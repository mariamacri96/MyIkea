package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COMMAND")
public class Command {    // I don't know why if I try to rename it Order it will throws some exceptions

    public enum State {
        TRANSMITTED, IN_PROCESSING, CLOSED      // maybe?? I don't know
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Enumerated
    @Column(name = "STATE")
    private State state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER", referencedColumnName = "ID")
    private User user;

    @OneToOne(mappedBy = "command")
    private Bill bill;

    @ManyToMany
    @JoinTable(     // the quantity must be handled
            name = "ORDERED",
            joinColumns = @JoinColumn(name = "COMMAND", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")
    )
    private List<Product> products = new ArrayList<Product>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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
        Command command = (Command) o;
        return Objects.equals(id, command.id) && state == command.state && Objects.equals(user, command.user) && Objects.equals(bill, command.bill) && Objects.equals(products, command.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, user, bill, products);
    }
}
