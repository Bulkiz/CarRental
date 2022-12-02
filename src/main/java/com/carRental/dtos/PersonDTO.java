package com.carRental.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PersonDTO {

    private Integer id;
    private String name;
    private String pin;
    private String email;
    private String phoneNumber;
    private AddressDTO addressDTO;

}
