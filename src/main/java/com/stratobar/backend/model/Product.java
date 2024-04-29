package com.stratobar.backend.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private String price;
    private String type_product;
    private String State;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getType_product() {
        return type_product;
    }
    public void setType_product(String type_product) {
        this.type_product = type_product;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", type_product=" + type_product + ", State=" + State + "]";
    }

}
