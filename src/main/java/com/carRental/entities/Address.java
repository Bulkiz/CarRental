package com.carRental.entities;

import com.carRental.enums.AddressType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city")
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "street")
    private String street;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "type", columnDefinition = "int2")
    private AddressType addressType;
}
