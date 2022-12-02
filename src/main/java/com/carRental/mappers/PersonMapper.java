package com.carRental.mappers;

import com.carRental.dtos.PersonDTO;
import com.carRental.entities.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PersonMapper implements ModelMapper<PersonDTO, Person> {

    private final AddressMapper addressMapper;

    public PersonMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
    @Override
    public PersonDTO toDto(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .pin(person.getPin())
                .email(person.getEmail())
                .phoneNumber(person.getPhoneNumber())
                .addressDTO(addressMapper.toDto(person.getAddress()))
                .build();
    }

    @Override
    public Person toEntity(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.getId())
                .name(personDTO.getName())
                .pin(personDTO.getPin())
                .email(personDTO.getEmail())
                .phoneNumber(personDTO.getPhoneNumber())
                .address(addressMapper.toEntity(personDTO.getAddressDTO()))
                .build();
    }

    @Override
    public List<PersonDTO> allToDtos(List<Person> people) {
        return people.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Person> allToEntities(List<PersonDTO> personDTOS) {
        return personDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
