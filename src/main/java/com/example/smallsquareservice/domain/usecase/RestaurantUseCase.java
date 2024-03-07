package com.example.smallsquareservice.domain.usecase;

import com.example.smallsquareservice.domain.usecase.validation.Validation;
import com.example.smallsquareservice.domain.api.IRestaurantServicePort;
import com.example.smallsquareservice.domain.exception.*;
import com.example.smallsquareservice.domain.model.Restaurant;
import com.example.smallsquareservice.domain.spi.IRestaurantPersistencePort;
import org.springframework.data.domain.Page;

public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        if (Validation.emptyFields(restaurant)) throw new EmptyFields();
        else if(Validation.veryLongNumber(restaurant.getPhone())) throw new VeryLongPhoneNumber();
        else if(Validation.phoneStructure(restaurant.getPhone())) throw new InvalidPhoneStructure();
        else if(Validation.validateRestaurantName(restaurant.getNameRestaurant())) throw new NameWithOnlyNumbers();
        else if(Validation.validateNit(restaurant.getNit())) throw new NitWithLetters();
        restaurantPersistencePort.saveRestaurant(restaurant);
    }

    @Override
    public Page<Restaurant> getRestaurants(int page, int size) {
        if (Validation.negativeNumbers(page,size)) throw new InvalidPage();
        return restaurantPersistencePort.getRestaurants(page, size);
    }
}
