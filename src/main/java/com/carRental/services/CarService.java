package com.carRental.services;

import com.carRental.dtos.CarDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    public List<CarDTO> findAll();
}
