package com.carRental.entities;

import com.carRental.enums.CarType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "type", columnDefinition = "int2")
    private CarType carType;

    @Column(name = "doors")
    private Integer doors;

    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private Date year;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "r_cars_garages",
    joinColumns = @JoinColumn(name = "car_id"),
    inverseJoinColumns = @JoinColumn(name = "garage_id"))
    private Garage garage;
}
