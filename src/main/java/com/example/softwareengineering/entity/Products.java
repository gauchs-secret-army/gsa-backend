package com.example.softwareengineering.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "Products")
public class Products {
    private Integer productID;
    private String name;
    private String price;
    @Lob
    private Blob image;
    private Integer stock;

    public Products() {
    }
    public Products(Integer productID, String Name, String Price, Blob Image, Integer Stock) {
        this.productID = productID;
        this.name = Name;
        this.price = Price;
        this.image = Image;
        this.stock = Stock;
    }
    public Integer getProductID() { return productID; }
    public void setProductID(Integer productID) { this.productID = productID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public Blob getImage() { return image; }
    public void setImage(Blob image) { this.image = image; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
