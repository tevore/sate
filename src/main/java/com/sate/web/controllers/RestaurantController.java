package com.sate.web.controllers;

import com.sate.web.requests.CreateRestaurantRequest;
import com.sate.web.responses.ApiResponse;
import com.sate.services.RestaurantManageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantManageService restaurantManageService;

    @Inject
    public RestaurantController(RestaurantManageService restaurantManageService) {
        this.restaurantManageService = restaurantManageService;
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public ApiResponse createRestaurant(@NotNull @Valid CreateRestaurantRequest restaurantRequest) {
        LOGGER.info("Attempting to create new restaurant...");
        return restaurantManageService.createRestaurant(restaurantRequest);
    }


    //TODO add distance search for provided GPS data or retrieve top from my ToGoTo list
    //retrieve via name search
    @Get
    public ApiResponse retrieveRestaurant(@QueryValue String name,
                                          @QueryValue(defaultValue = "0") Integer page,
                                          @QueryValue(defaultValue = "5") Integer size) {
        LOGGER.info("Seeking restaurant like {}", name);
        return restaurantManageService.retrieveRestaurant(name, page, size);
    }
}
