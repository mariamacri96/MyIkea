package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLACE")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="NOTE")
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "SHELF", referencedColumnName = "ID")
    private Shelf shelf;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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
        return Objects.equals(id, place.id) &&
                Objects.equals(name, place.name) &&
                Objects.equals(note, place.note) &&
                Objects.equals(shelf, place.shelf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shelf);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", shelf=" + shelf +
                '}';
    }
}