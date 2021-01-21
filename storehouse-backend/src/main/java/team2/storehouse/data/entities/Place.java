package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PLACE")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name="NOTE")
    private String note;



    @ManyToOne(optional = false)
    @JoinColumn(name = "SHELF", referencedColumnName = "ID")
    private Shelf shelf;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(id, place.id) &&
                Objects.equals(nome, place.nome) &&
                Objects.equals(note, place.note) &&
                Objects.equals(shelf, place.shelf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}