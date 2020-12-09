package team2.storehouse.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;

    @Basic(optional = false)
    @Column(name = "BRAND")
    private String brand;

    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "PHOTO")
    private String photo;  // link

    @Basic(optional = false)
    @Column(name = "STOCK")
    private int stock;

    @OneToOne(optional = false)
    @JoinColumn(name = "PLACE", referencedColumnName = "ID")
    private Place place;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SUBCATEGORY", referencedColumnName = "ID")
    private Subcategory subcategory;

    @ManyToOne(optional = false)
    @JoinColumn(name = "VENDOR", referencedColumnName = "ID")
    private Vendor vendor;

    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();

    @ManyToMany(mappedBy = "products")
    private List<Command> commands = new ArrayList<Command>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public List<Command> getOrders() {
        return commands;
    }

    public void setOrders(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(brand, product.brand) && Objects.equals(color, product.color) && Objects.equals(size, product.size) && Objects.equals(photo, product.photo) && Objects.equals(place, product.place) && Objects.equals(subcategory, product.subcategory) && Objects.equals(vendor, product.vendor) && Objects.equals(shoppingCarts, product.shoppingCarts) && Objects.equals(commands, product.commands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, price, color, size, photo, stock, place, subcategory, vendor, shoppingCarts, commands);
    }
}
