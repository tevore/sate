package com.sate.web.controllers.requests;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Introspected
public class CreateRestaurantRequest {

    @NotBlank
    private String name;
    //TODO make this an enum or keep as freeform for fusion?
    @NotBlank
    private String cuisine;
    @Valid @NotNull
    private Address address;
}
