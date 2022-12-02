package com.carRental.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GarageDTO {

    private Integer id;
    private String name;
    private Integer capacity;
    private AddressDTO addressDTO;
    
}
