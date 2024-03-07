package com.example.smallsquareservice.application.handler;

import com.example.smallsquareservice.application.dto.RestaurantRequest;
import com.example.smallsquareservice.application.dto.RestaurantResponse;
import org.springframework.data.domain.Page;

public interface IRestaurantHandler {
    void saveRestaurant(RestaurantRequest restaurantRequest);
    Page<RestaurantResponse> getRestaurants(int page, int size);

}
