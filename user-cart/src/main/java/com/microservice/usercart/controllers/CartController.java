package com.microservice.usercart.controllers;

import com.microservice.usercart.models.Shoes;
import com.microservice.usercart.models.UserCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    public RestTemplate restTemplate;

    private final Map<Long, UserCart> userCartMap = new HashMap<>();

    @GetMapping("/{userId}")
    public List<Shoes> getCart(@PathVariable Long userId) {
        UserCart userCart = userCartMap.getOrDefault(userId, new UserCart(userId));
        return userCart.getUserShoesList();
    }

    @PostMapping("/{userId}/{shoesId}")
    public Shoes addItemInCart(@PathVariable Long userId, @PathVariable Long shoesId) {
        Shoes shoesDetails = restTemplate.getForObject("http://localhost:8082/shoes/" + shoesId, Shoes.class);

        if (shoesDetails != null) {
            UserCart userCart = userCartMap.computeIfAbsent(userId, k -> new UserCart(userId));
            userCart.getUserShoesList().add(shoesDetails);
            return shoesDetails;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{userId}/{shoesId}")
    public void removeItemInCart(@PathVariable Long userId, @PathVariable Long shoesId) {
        userCartMap.computeIfPresent(userId, (key, userCart) -> {
            userCart.getUserShoesList().removeIf(shoes -> shoes.getId().equals(shoesId));
            return userCart;
        });
    }
}