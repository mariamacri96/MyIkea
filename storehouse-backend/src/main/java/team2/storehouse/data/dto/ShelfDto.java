package team2.storehouse.data.dto;

import java.io.Serializable;

public class ShelfDto implements Serializable {
    private Long id;

    private String name;

    private String note;

    public String setName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ShelfDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
