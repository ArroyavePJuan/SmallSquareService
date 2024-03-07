package com.example.smallsquareservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishUpdateRequest {

    private Integer price;
    private String description;

}
