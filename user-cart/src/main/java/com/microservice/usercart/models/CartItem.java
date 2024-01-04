package com.microservice.usercart.models;

public class CartItem {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CartItem(String id) {
        this.id = id;
    }
}
