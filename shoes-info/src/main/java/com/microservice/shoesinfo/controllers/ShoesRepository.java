package com.microservice.shoesinfo.controllers;

import com.microservice.shoesinfo.models.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {

}
