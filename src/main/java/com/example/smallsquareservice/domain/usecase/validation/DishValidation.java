package com.example.smallsquareservice.domain.usecase.validation;

import com.example.smallsquareservice.domain.model.Dish;

public class DishValidation {
    private DishValidation() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean emptyFields(Dish dish){

        return empty(dish.getDishName()) || empty(dish.getDescription()) || empty(dish.getUrlImage()) || dish.getPrice()==null
                || dish.getCategoryId() == null || dish.getRestaurantId()== null;

    }
    private static boolean empty(String string){
        return string.isEmpty() || string.isBlank();
    }
    public static boolean invalidPrice(int price){
        return price <= 0;
    }
}

