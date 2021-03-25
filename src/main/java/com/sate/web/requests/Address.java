package com.sate.web.requests;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Introspected
public class Address {

    @NotBlank
    private String address1;
    private String address2;
    @NotBlank
    private String city;
    @NotBlank
    private String stateCode;
    @NotBlank
    private String postalCode;
    private Coordinates coordinates;
}
