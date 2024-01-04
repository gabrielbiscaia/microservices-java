package com.microservice.shoesinfo.resources;

import com.microservice.shoesinfo.models.Shoes;
import com.microservice.shoesinfo.models.UserShoesList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/shoes")
public class ShoesResource {

    @RequestMapping("/{shoesId}")
    public Shoes getShoesInfo(@PathVariable("shoesId") String shoesId){
        //equalsIgnoreCase -> ignore case sensitive
        if ("AJ1".equalsIgnoreCase(shoesId)) {
            return new Shoes("AJ1", "Air Jordan 1", "The most iconic nike shoes");
        } else if ("MB02".equalsIgnoreCase(shoesId)) {
            return new Shoes("MB02", "Melo Ball 02", "The most comfortable puma shoes");
        } else if ("TY3".equalsIgnoreCase(shoesId)) {
            return new Shoes("TY3", "Trae Young 3","The coolest design of a basketball shoes");
        } else {
            // if none of IDs are know
            return new Shoes("Unknown Shoe", "Name not available","Details not available");
        }
    }

    @RequestMapping("users/{userId}")
    public UserShoesList getUserShoes(@PathVariable("userId") String userId){
        List<Shoes> shoesList;

        // try to find a user's cart
        if ("gabriel".equalsIgnoreCase(userId)) {
            shoesList = Arrays.asList(
                    new Shoes("AJ1", "Air Jordan 1", "The most iconic nike shoes"),
                    new Shoes("MB02", "Melo Ball 02", "The most comfortable puma shoes")
            );
        } else if ("pedro".equalsIgnoreCase(userId)) {
            shoesList = Arrays.asList(
                    new Shoes("AJ1", "Air Jordan 1", "The most iconic nike shoes"),
                    new Shoes("TY3", "Trae Young 3","The coolest design of a basketball shoes")
            );
        } else if ("lucas".equalsIgnoreCase(userId)) {
            shoesList = Arrays.asList(
                    new Shoes("MB02", "Melo Ball 02", "The most comfortable puma shoes"),
                    new Shoes("TY3", "Trae Young 3","The coolest design of a basketball shoes")
            );
        } else {
            // if none of users are known
            shoesList = Arrays.asList(
                    new Shoes("Unknown Shoe 1", "Name not available", "Details not available"),
                    new Shoes("Unknown Shoe 2", "Name not available","Details not available"),
                    new Shoes("Unknown Shoe 3", "Name not available","Details not available")
            );
        }

        // instances a userShoeList
        UserShoesList userShoesList = new UserShoesList();

        //assign a shoeList to a UserShoesList
        userShoesList.setUserShoesList(shoesList);

        //return a userShoesList
        return userShoesList;
    }
}