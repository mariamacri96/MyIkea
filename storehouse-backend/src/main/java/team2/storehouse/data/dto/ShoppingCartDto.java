package team2.storehouse.data.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDto {

    List<ElementDto> elements = new ArrayList<>();

    public List<ElementDto> getElements() {
        return elements;
    }

    public void setElements(List<ElementDto> elements) {
        this.elements = elements;
    }
}
