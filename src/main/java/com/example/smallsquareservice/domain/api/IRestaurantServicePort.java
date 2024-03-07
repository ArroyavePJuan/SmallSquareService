package com.example.smallsquareservice.domain.api;

import com.example.smallsquareservice.domain.model.Restaurant;
import org.springframework.data.domain.Page;

public interface IRestaurantServicePort {
    void saveRestaurant(Restaurant restaurant);
    Page<Restaurant> getRestaurants(int page, int size);
}
