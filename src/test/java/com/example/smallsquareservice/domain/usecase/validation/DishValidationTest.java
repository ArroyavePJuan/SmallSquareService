package com.example.smallsquareservice.domain.usecase.validation;

import com.example.smallsquareservice.domain.model.Dish;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishValidationTest {

    @Test
    void completeFields() {
        Dish dish = new Dish();
        dish.setDishName("plato");
        dish.setCategoryId(1L);
        dish.setDescription("platooo");
        dish.setPrice(1);
        dish.setRestaurantId(1L);
        dish.setUrlImage("PALTO.JPG");
        assertFalse(DishValidation.emptyFields(dish));
    }
    @Test
    void emptyFields() {
        Dish dish = new Dish();
        dish.setDishName("");
        dish.setCategoryId(1L);
        dish.setDescription("platooo");;
        dish.setPrice(1);
        dish.setRestaurantId(1L);
        dish.setUrlImage("PALTO.JPG");
        assertTrue(DishValidation.emptyFields(dish));
    }

    @Test
    void invalidPriceNegativeNumbersOrZero() {
        assertTrue(DishValidation.invalidPrice(-400000));
        assertTrue(DishValidation.invalidPrice(0));
    }
    @Test
    void validPrice(){
        assertFalse(DishValidation.invalidPrice(40000));
    }

}