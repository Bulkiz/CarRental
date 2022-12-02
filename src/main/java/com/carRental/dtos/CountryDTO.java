package com.carRental.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CountryDTO {

    private Integer id;
    private String name;
    private Boolean isActive;

}
