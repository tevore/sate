package com.sate.services;

import com.sate.web.controllers.requests.CreateRestaurantRequest;
import com.sate.web.controllers.responses.ApiResponse;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class RestaurantManageService {

    public RestaurantManageService() {
    }

    public ApiResponse createRestaurant(CreateRestaurantRequest restaurantRequest) {
        return new ApiResponse("received", 200);
    }


}
