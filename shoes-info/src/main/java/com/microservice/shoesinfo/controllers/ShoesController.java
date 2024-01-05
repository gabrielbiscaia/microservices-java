package com.microservice.shoesinfo.controllers;

import com.microservice.shoesinfo.models.Shoes;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ShoesController {

    ShoesRepository shoesRepository;

    @GetMapping("/shoes")
    public List<Shoes> getAllShoes(){
        return shoesRepository.findAll();
    }

    @GetMapping("/shoes/{id}")
    public Shoes getShoesById(@PathVariable Long id){
        return shoesRepository.getReferenceById(id);
    }

    @PostMapping("/shoes")
    public Shoes saveShoes(@RequestBody Shoes shoes){
        return shoesRepository.save(shoes);
    }

    @DeleteMapping("/shoes/{id}")
    public void deleteShoes(@PathVariable Long id){
        shoesRepository.deleteById(id);
    }

}
