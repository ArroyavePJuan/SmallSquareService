package com.example.smallsquareservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RestaurantRequest {

    private String nameRestaurant;
    private String address;
    private Long ownerId;
    private String phone;
    private String urlLogo;
    private String nit;
}
