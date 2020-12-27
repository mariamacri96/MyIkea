package team2.storehouse.data.dto;

import java.io.Serializable;

public class ShelfDto implements Serializable {
    private Long id;

    public ShelfDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
