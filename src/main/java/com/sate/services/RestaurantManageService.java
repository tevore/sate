package com.sate.services;

import com.sate.entities.Restaurant;
import com.sate.entities.repositories.RestaurantRepository;
import com.sate.web.controllers.requests.CreateRestaurantRequest;
import com.sate.web.controllers.responses.ApiResponse;
import io.micronaut.context.annotation.Prototype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Prototype
public class RestaurantManageService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestaurantManageService.class);

    private RestaurantRepository restaurantRepository;

    @Inject
    public RestaurantManageService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public ApiResponse createRestaurant(CreateRestaurantRequest restaurantRequest) {
        try {
            restaurantRepository.save(new Restaurant(
                    restaurantRequest.getName(),
                    restaurantRequest.getCuisine(),
                    restaurantRequest.getAddress().getAddress1(),
                    restaurantRequest.getAddress().getAddress2(),
                    restaurantRequest.getAddress().getCity(),
                    restaurantRequest.getAddress().getStateCode(),
                    restaurantRequest.getAddress().getPostalCode()));
        } catch(Exception e) {
            LOGGER.error("Blew up: " + e.getMessage());
            e.printStackTrace();
        }
        return new ApiResponse("Restaurant added", 200);
    }


}
