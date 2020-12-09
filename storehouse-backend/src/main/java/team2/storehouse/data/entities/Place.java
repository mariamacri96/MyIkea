package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLACE")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "place")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SHELF", referencedColumnName = "ID")
    private Shelf shelf;

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

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(id, place.id) && Objects.equals(product, place.product) && Objects.equals(shelf, place.shelf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, shelf);
    }
}