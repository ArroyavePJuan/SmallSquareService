package com.example.smallsquareservice.domain.api;

import com.example.smallsquareservice.domain.model.Dish;
import org.springframework.data.domain.Page;


public interface IDishServicePort {

    Dish saveDish(Dish dish);
    Dish getDish(Long id);
    Dish updateDish(Dish dish);
    Dish updateStatusDish(Dish dish);
    Page<Dish> getDishes(String category, int page, int size);
}
