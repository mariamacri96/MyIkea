package team2.storehouse.data.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDto implements Serializable {

    List<ElementDto> elements = new ArrayList<>();

    public List<ElementDto> getElements() {
        return elements;
    }

    public void setElements(List<ElementDto> elements) {
        this.elements = elements;
    }
}
