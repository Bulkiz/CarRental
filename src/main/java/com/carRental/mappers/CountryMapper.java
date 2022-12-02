package com.carRental.mappers;

import com.carRental.dtos.CountryDTO;
import com.carRental.entities.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryMapper implements ModelMapper<CountryDTO, Country> {
    @Override
    public CountryDTO toDto(Country country) {
        return CountryDTO.builder()
                .id(country.getId())
                .name(country.getName())
                .isActive(country.getIsActive())
                .build();
    }

    @Override
    public Country toEntity(CountryDTO countryDTO) {
        return Country.builder()
                .id(countryDTO.getId())
                .name(countryDTO.getName())
                .isActive(countryDTO.getIsActive())
                .build();
    }

    @Override
    public List<CountryDTO> allToDtos(List<Country> countries) {
        return countries.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Country> allToEntities(List<CountryDTO> countryDTOS) {
        return countryDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
