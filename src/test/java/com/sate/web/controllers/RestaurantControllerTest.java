package com.sate.web.controllers;

import com.sate.web.controllers.requests.Address;
import com.sate.web.controllers.requests.CreateRestaurantRequest;
import com.sate.web.controllers.responses.ApiResponse;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class RestaurantControllerTest {

    @Inject
    private EmbeddedServer server;

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
    void createRestaurant() {

        CreateRestaurantRequest createRestaurantRequest = new CreateRestaurantRequest();
        createRestaurantRequest.setName("Cote");
        createRestaurantRequest.setCuisine("Korean");
        createRestaurantRequest.setAddress(new Address("123 St", "123", "134", "123", "123"));

        HttpResponse<ApiResponse> httpApiResponse = client.toBlocking().exchange(HttpRequest.POST("/restaurant", createRestaurantRequest), ApiResponse.class);

        ApiResponse apiResponse = new ApiResponse("Restaurant added", 200);

        assertEquals(apiResponse.toString(), httpApiResponse.body().toString());
    }
}