package com.sophie.miller.roomwithlivedata.objects;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String productName;
    private String productDescription;
    private double price;

    @Ignore
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    @Ignore
    public Product(String productName, String productDescription, double price) {
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
    }

    public Product(int id, String productName, String productDescription, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
