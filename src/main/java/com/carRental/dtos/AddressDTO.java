package com.carRental.dtos;

import com.carRental.enums.AddressType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDTO {

    private Integer id;
    private String city;
    private CountryDTO countryDTO;
    private String street;
    private Boolean isActive;
    private AddressType addressType;
}
