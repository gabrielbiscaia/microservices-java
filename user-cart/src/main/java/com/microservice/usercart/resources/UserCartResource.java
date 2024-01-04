package com.microservice.usercart.resources;

import com.microservice.usercart.models.CartItem;
import com.microservice.usercart.models.Shoes;
import com.microservice.usercart.models.UserShoesList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class UserCartResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable("userId") String userId) {

        //return a list of shoes of a user
        UserShoesList shoesList = restTemplate.getForObject("http://localhost:8082/shoes/users/" + userId, UserShoesList.class);
        System.out.println(shoesList);

        assert shoesList != null;
        return shoesList.getUserShoesList().stream()
                .map(shoes -> {
                    //for each shoe, call shoes info service and get details
                    Shoes shoesInCart = restTemplate.getForObject("http://localhost:8082/shoes/" + shoes.getId(), Shoes.class);

                    // Check for null before accessing the properties
                    if (shoesInCart != null) {
                        //Put them all together
                        return new CartItem(shoesInCart.getName(), shoesInCart.getDescription());
                    } else {
                        // Handle the case where shoesDetails is null
                        return null;
                    }
                })
                // Filter out null CartItems
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}