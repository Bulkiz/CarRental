package com.carRental.mappers;

import com.carRental.dtos.AddressDTO;
import com.carRental.dtos.GarageDTO;
import com.carRental.entities.Garage;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GarageMapper implements ModelMapper<GarageDTO, Garage> {
    private final AddressMapper addressMapper;

    public GarageMapper(AddressMapper addressMapper){
        this.addressMapper = addressMapper;
    }
    @Override
    public GarageDTO toDto(Garage garage) {
        return GarageDTO.builder()
                .id(garage.getId())
                .name(garage.getName())
                .capacity(garage.getCapacity())
                .addressDTO(addressMapper.toDto(garage.getAddress()))
                .build();
    }

    @Override
    public Garage toEntity(GarageDTO garageDTO) {
        return Garage.builder()
                .id(garageDTO.getId())
                .name(garageDTO.getName())
                .capacity(garageDTO.getCapacity())
                .address(addressMapper.toEntity(garageDTO.getAddressDTO()))
                .build();
    }

    @Override
    public List<GarageDTO> allToDtos(List<Garage> garages) {
        return garages.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Garage> allToEntities(List<GarageDTO> garageDTOS) {
        return garageDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
