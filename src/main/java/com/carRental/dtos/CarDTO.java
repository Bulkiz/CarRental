package com.carRental.dtos;

import com.carRental.entities.Garage;
import com.carRental.entities.Person;
import com.carRental.enums.CarType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class CarDTO {

    private Integer id;
    private String make;
    private String model;
    private CarType carType;
    private Integer doors;
    private String color;
    private Date year;
    private Boolean isActive;
    private PersonDTO personDTO;
    private GarageDTO garageDTO;
}
