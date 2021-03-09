package com.sate.entities;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "restaurants")
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String cuisine;

    @NotBlank
    private String address1;

    private String address2;

    @NotBlank
    private String city;

    @NotBlank
    @Column(name = "state_code")
    private String stateCode;

    @NotBlank
    @Column(name = "postal_code")
    private String postalCode;

    //JPA requirement
    protected Restaurant() {}

    public Restaurant(String name, String cuisine, String address1, String address2, String city, String stateCode, String postalCode) {
        this.name = name;
        this.cuisine = cuisine;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.stateCode = stateCode;
        this.postalCode = postalCode;
    }

}
