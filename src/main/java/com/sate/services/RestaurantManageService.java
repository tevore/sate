package com.sate.services;

import com.sate.entities.Restaurant;
import com.sate.entities.repositories.RestaurantRepository;
import com.sate.web.requests.CreateRestaurantRequest;
import com.sate.web.responses.ApiResponse;
import com.sate.web.responses.RetrievalResponse;
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
        return new ApiResponse("Restaurant added", 200, null);
    }


    public ApiResponse retrieveRestaurant(String name, Integer page, Integer size) {
        //TODO add test for cases and likes
        //TODO alter query to lower case values during retrieval
        Page<Restaurant> pages = restaurantRepository.findByNameLike("%"+name+"%", Pageable.from(page, size));
        LOGGER.info("Total pages found via query: {}", pages.getTotalPages());
        RetrievalResponse retrievalResponse = new RetrievalResponse();
        pages.getContent().stream().forEach(r -> retrievalResponse.getRestaurants().add(r));
        return new ApiResponse("Results found", 200, retrievalResponse);
    }
}
