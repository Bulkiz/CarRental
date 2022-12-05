package com.carRental.controllers;

import com.carRental.dtos.CarDTO;
import com.carRental.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    public final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.findAll());
    }



}
