package com.sate.web.controllers

import com.sate.services.RestaurantManageService
import com.sate.web.controllers.requests.Address
import com.sate.web.controllers.requests.CreateRestaurantRequest
import com.sate.web.controllers.responses.ApiResponse
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class RestaurantControllerSpec extends Specification {

    @Inject
    RestaurantManageService restaurantManageService

    @Inject
    @Client("/")
    private HttpClient client

    void "should successfully create entity"() {
        when:
        def createRestaurantRequest = new CreateRestaurantRequest()
        createRestaurantRequest.setName("Cote")
        createRestaurantRequest.setCuisine("Korean")
        createRestaurantRequest.setAddress(new Address("123 St", "123", "134", "123", "123"))
        def httpApiResponse = client.toBlocking().exchange(HttpRequest.POST("/restaurant", createRestaurantRequest), ApiResponse)
        then:
        restaurantManageService.createRestaurant(_) >> new ApiResponse("Restaurant added", 200)
        200 == httpApiResponse.body().statusCode
        "Restaurant added" == httpApiResponse.body().message
    }



    @MockBean(RestaurantManageService)
    RestaurantManageService restaurantManageServiceMock() {
        Mock(RestaurantManageService)
    }
}
