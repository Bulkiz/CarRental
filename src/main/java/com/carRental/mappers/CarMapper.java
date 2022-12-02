package com.carRental.mappers;

import com.carRental.dtos.CarDTO;
import com.carRental.entities.Car;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper implements ModelMapper<CarDTO, Car> {

    private final PersonMapper personMapper;
    private final GarageMapper garageMapper;

    public CarMapper(PersonMapper personMapper, GarageMapper garageMapper) {
        this.personMapper = personMapper;
        this.garageMapper = garageMapper;
    }
    @Override
    public CarDTO toDto(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .make(car.getMake())
                .model(car.getModel())
                .carType(car.getCarType())
                .doors(car.getDoors())
                .color(car.getColor())
                .year(car.getYear())
                .isActive(car.getIsActive())
                .personDTO(personMapper.toDto(car.getPerson()))
                .garageDTO(garageMapper.toDto(car.getGarage()))
                .build();
    }

    @Override
    public Car toEntity(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .make(carDTO.getMake())
                .model(carDTO.getModel())
                .carType(carDTO.getCarType())
                .doors(carDTO.getDoors())
                .color(carDTO.getColor())
                .year(carDTO.getYear())
                .isActive(carDTO.getIsActive())
                .person(personMapper.toEntity(carDTO.getPersonDTO()))
                .garage(garageMapper.toEntity(carDTO.getGarageDTO()))
                .build();
    }

    @Override
    public List<CarDTO> allToDtos(List<Car> cars) {
        return cars.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Car> allToEntities(List<CarDTO> carDTOS) {
        return carDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
