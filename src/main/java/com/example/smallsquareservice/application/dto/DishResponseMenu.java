package com.example.smallsquareservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DishResponseMenu {
    private String dishName;
    private String description;
    private Integer price;
    private String urlImage;
}
