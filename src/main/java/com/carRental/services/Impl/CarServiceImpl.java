package com.carRental.services.Impl;

import com.carRental.dtos.CarDTO;
import com.carRental.entities.Car;
import com.carRental.mappers.CarMapper;
import com.carRental.repositories.CarRepository;
import com.carRental.services.CarService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
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


    @Override
    public CarDTO findById(Integer id) {
        return carMapper.toDto(carRepository.findById(id).get());
    }

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        carRepository.save(car);
        return carMapper.toDto(car);
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        return createCar(carMapper.toDto(car));
    }
}
