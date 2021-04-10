package com.example.softwareengineering.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    private Integer productID;
    private String ProductName;
    private String price;
    private String images;
    private Integer stock;

    public Products() {
    }
    public Products(String productname, String Price, String Images, Integer Stock) {
        this.productID = (int)(Math.random()*89999)+10000;
        this.ProductName = productname;
        this.price = Price;
        this.images = Images;
        this.stock = Stock;
    }
    public Products(Integer productID, String productname, String Price, String Images, Integer Stock) {
        this.productID = productID;
        this.ProductName = productname;
        this.price = Price;
        this.images = Images;
        this.stock = Stock;
    }
    public Integer getProductID() { return productID; }
    public void setProductID(Integer productID) { this.productID = productID; }
    public String getName() { return ProductName; }
    public void setName(String name) { this.ProductName = name; }
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public String getImage() { return images; }
    public void setImage(String image) { this.images = image; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
