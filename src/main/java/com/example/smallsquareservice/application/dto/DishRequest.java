package com.example.smallsquareservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DishRequest {
    private String dishName;
    private Long categoryId;
    private String description;
    private Integer price;
    private Long restaurantId;
    private String urlImage;
}
