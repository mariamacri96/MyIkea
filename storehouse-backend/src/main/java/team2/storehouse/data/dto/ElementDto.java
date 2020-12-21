package team2.storehouse.data.dto;

import team2.storehouse.data.entities.Product;

import java.io.Serializable;

public class ElementDto implements Serializable {

    Product product;

    int quantity;

    public ElementDto() {
    }

    public ElementDto(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
