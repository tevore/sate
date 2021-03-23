package com.sate.services;

import com.sate.entities.Restaurant;
import com.sate.entities.repositories.RestaurantRepository;
import com.sate.web.controllers.requests.CreateRestaurantRequest;
import com.sate.web.controllers.responses.ApiResponse;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
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
        LOGGER.info("Creating restaurant in service...");
        try {
            Restaurant restaurant = restaurantRepository.save(new Restaurant(
                    restaurantRequest.getName(),
                    restaurantRequest.getCuisine(),
                    restaurantRequest.getAddress().getAddress1(),
                    restaurantRequest.getAddress().getAddress2(),
                    restaurantRequest.getAddress().getCity(),
                    restaurantRequest.getAddress().getStateCode(),
                    restaurantRequest.getAddress().getPostalCode()));

            LOGGER.info("{} successfully added as restaurant entry {}", restaurant.getName(), restaurant.getId());
        } catch(Exception e) {
            LOGGER.error("Blew up: " + e.getMessage());
            e.printStackTrace();
        }
        return new ApiResponse("Restaurant added", 200);
    }


    public ApiResponse retrieveRestaurant(String name) {
        Page<Restaurant> pages = restaurantRepository.findByNameLike("%"+name+"%", Pageable.from(0, 5));
        LOGGER.info("Total pages found via query: {}", pages.getTotalPages());
        Restaurant r = pages.getContent().get(0);
        return new ApiResponse(r.toString(), 200);
    }
}
