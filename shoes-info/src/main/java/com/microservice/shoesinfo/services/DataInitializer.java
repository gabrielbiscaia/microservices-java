package com.microservice.shoesinfo.services;

import com.microservice.shoesinfo.controllers.ShoesRepository;
import com.microservice.shoesinfo.models.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ShoesRepository shoesRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeShoes();
    }

    public void initializeShoes() {
        List<Shoes> shoesList = Arrays.asList(
            new Shoes(1L, "Air Jordan 1", "The iconic Nike basketball shoes"),
            new Shoes(2L,"Adidas Superstar", "Classic Adidas sneakers"),
            new Shoes(3L,"Nike React Element", "Modern and comfortable Nike shoes"),
            new Shoes(4L,"MB02", "Puma's best cushioning basketball shoes"),
            new Shoes(5L,"AE1", "The promise of basketball shoes evolution")
        );
        shoesRepository.saveAll(shoesList);
    }
}
