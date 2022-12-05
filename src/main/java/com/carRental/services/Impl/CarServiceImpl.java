package com.carRental.services.Impl;

import com.carRental.dtos.CarDTO;
import com.carRental.mappers.CarMapper;
import com.carRental.repositories.CarRepository;
import com.carRental.services.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    public final CarRepository carRepository;
    public final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper){
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }
    @Override
    public List<CarDTO> findAll() {
        return carMapper.allToDtos(carRepository.findAll());
    }
}
