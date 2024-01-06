package com.microservice.usercart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_cart_id")
    List<Shoes> userShoesList;

    public UserCart(Long userId) {
        this.userId = userId;
        this.userShoesList = new ArrayList<>();
    }
}
