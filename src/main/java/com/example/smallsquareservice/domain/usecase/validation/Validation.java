package com.example.smallsquareservice.domain.usecase.validation;

import com.example.smallsquareservice.domain.model.Restaurant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private Validation() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean emptyFields(Restaurant restaurant){
        return empty(restaurant.getNameRestaurant()) || empty(restaurant.getAddress()) || empty(restaurant.getNit())
                || empty(restaurant.getPhone()) || empty(restaurant.getUrlLogo()) || restaurant.getOwnerId()==0 || restaurant.getOwnerId()==null;

    }
    private static boolean empty(String string){
        return string.isEmpty() || string.isBlank();
    }
    public static boolean veryLongNumber(String phone){
        return phone.length()>13;
    }
    private static final String PHONE_REGEX = "^\\+?\\d{1,12}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    public static boolean phoneStructure(String phone){
        Matcher matcher = PHONE_PATTERN.matcher(phone);
        return !matcher.matches();
    }
    public static boolean validateNit(String nit){
        return !nit.matches("\\d+");
    }
    public static boolean validateRestaurantName(String name){
        return name.matches("\\d+");
    }
    public static boolean negativeNumbers(int page, int size){return page < 1 || size < 1;}

}
