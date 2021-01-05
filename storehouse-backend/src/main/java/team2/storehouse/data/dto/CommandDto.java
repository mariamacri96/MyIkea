package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Command;
import team2.storehouse.data.entities.Ordered;
import team2.storehouse.data.entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandDto implements Serializable {

    Long id;

    User user;

    Command.State state;

    List<ElementDto> elements = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Command.State getState() {
        return state;
    }

    public void setState(Command.State state) {
        this.state = state;
    }

    public List<ElementDto> getElements() {
        return elements;
    }

    public void setElements(List<ElementDto> elements) {
        this.elements = elements;
    }
    public void setElementsfromOrdered(List<Ordered> orderedList) {
        for (Ordered o:orderedList
             ) {    elements.add(new ElementDto(o.getProduct(),o.getQuantity()));

        }


    }
}
