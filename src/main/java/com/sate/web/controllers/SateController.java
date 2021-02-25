package com.sate.web.controllers;

import com.sate.web.controllers.requests.AddDishRequest;
import com.sate.web.controllers.requests.CreateRestaurantRequest;
import com.sate.web.controllers.responses.ApiResponse;
import com.sate.services.RestaurantManageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;

@Controller("/sate")
public class SateController {

    private final RestaurantManageService restaurantManageService;

    @Inject
    public SateController(RestaurantManageService restaurantManageService) {
        this.restaurantManageService = restaurantManageService;
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse createRestaurant(CreateRestaurantRequest restaurantRequest) {
        return restaurantManageService.createRestaurant(restaurantRequest);
    }

//    @Post
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public ApiResponse addDish(AddDishRequest addDishRequest) {
//        return null;
//    }
}
