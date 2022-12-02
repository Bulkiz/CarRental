package com.carRental.mappers;

import com.carRental.dtos.AddressDTO;
import com.carRental.entities.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressMapper implements ModelMapper<AddressDTO, Address> {

    private final CountryMapper countryMapper;
    public AddressMapper(CountryMapper countryMapper){
        this.countryMapper = countryMapper;
    }
    @Override
    public AddressDTO toDto(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .city(address.getCity())
                .countryDTO(countryMapper.toDto(address.getCountry()))
                .street(address.getStreet())
                .isActive(address.getIsActive())
                .addressType(address.getAddressType())
                .build();
    }

    @Override
    public Address toEntity(AddressDTO addressDTO) {
        return Address.builder()
                .id(addressDTO.getId())
                .city(addressDTO.getCity())
                .country(countryMapper.toEntity(addressDTO.getCountryDTO()))
                .street(addressDTO.getStreet())
                .isActive(addressDTO.getIsActive())
                .addressType(addressDTO.getAddressType())
                .build();
    }

    @Override
    public List<AddressDTO> allToDtos(List<Address> addresses) {
        return addresses.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Address> allToEntities(List<AddressDTO> addressDTOS) {
        return addressDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}

