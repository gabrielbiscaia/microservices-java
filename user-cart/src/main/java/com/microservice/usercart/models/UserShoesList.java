package com.microservice.usercart.models;

import java.util.List;

public class UserShoesList {

    private List<Shoes> userShoesList;

    public List<Shoes> getUserShoesList() {
        return userShoesList;
    }

    public void setUserShoesList(List<Shoes> userShoesList) {
        this.userShoesList = userShoesList;
    }
}
