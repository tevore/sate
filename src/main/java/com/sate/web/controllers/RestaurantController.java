package com.sate.web.controllers;

import com.sate.web.controllers.requests.CreateRestaurantRequest;
import com.sate.web.controllers.responses.ApiResponse;
import com.sate.services.RestaurantManageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *  	It is critical that any blocking I/O operations
 *  	(such as fetching the data from the database) are
 *  	offloaded to a separate thread pool that does not block the Event loop.
 */
@ExecuteOn(TaskExecutors.IO)
@Controller("/restaurant")
public class RestaurantController {

    private final RestaurantManageService restaurantManageService;

    @Inject
    public RestaurantController(RestaurantManageService restaurantManageService) {
        this.restaurantManageService = restaurantManageService;
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse createRestaurant(@NotNull @Valid CreateRestaurantRequest restaurantRequest) {
        return restaurantManageService.createRestaurant(restaurantRequest);
    }


    //retrieve via id or name search or distance from?
//    @Get
//    public ApiResponse retrieveRestaurant() {
//
//    }
}
