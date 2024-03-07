package com.example.smallsquareservice.domain.spi;

import com.example.smallsquareservice.domain.model.Dish;
import org.springframework.data.domain.Page;


public interface IDishPersistencePort {

    Dish saveDish(Dish dish);
    Dish getDish(Long id);
    Dish updateDish(Dish dish);
    Page<Dish> getRestaurants(String category, int page, int size);

}
