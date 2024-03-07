package com.example.smallsquareservice.domain.spi;

import com.example.smallsquareservice.domain.model.Restaurant;
import org.springframework.data.domain.Page;

public interface IRestaurantPersistencePort {
    void saveRestaurant(Restaurant restaurant);
    Page<Restaurant> getRestaurants(int page, int size);
}
