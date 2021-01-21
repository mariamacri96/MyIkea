package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Shelf;

import java.io.Serializable;

public class PlaceDto implements Serializable {
    private Long id;

    private Shelf shelf;

    private String nome;

    private String note;


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
}
