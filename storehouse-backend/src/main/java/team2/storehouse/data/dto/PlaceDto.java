package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Shelf;

import java.io.Serializable;

public class PlaceDto implements Serializable {
    private Long id;

    private Shelf shelf;

    public PlaceDto() {
    }

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
}
