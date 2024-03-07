package com.example.smallsquareservice.application.handler;

import com.example.smallsquareservice.application.dto.RestaurantRequest;
import com.example.smallsquareservice.application.dto.RestaurantResponse;
import com.example.smallsquareservice.application.mapper.RestaurantMapper;
import com.example.smallsquareservice.domain.api.IRestaurantServicePort;
import com.example.smallsquareservice.domain.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RestaurantHandler implements IRestaurantHandler{

    private final IRestaurantServicePort restaurantServicePort;
    private final RestaurantMapper restaurantMapper;

    @Override
    public void saveRestaurant(RestaurantRequest restaurantRequest) {
        restaurantServicePort.saveRestaurant(restaurantMapper.toModel(restaurantRequest));
    }
    @Override
    public Page<RestaurantResponse> getRestaurants(int page, int size) {
        Page<Restaurant> restaurants = restaurantServicePort.getRestaurants(page, size);
        return restaurants.map(restaurantMapper::toResponse);
    }
}
