package com.example.smallsquareservice.infrastructure.ouput.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "dish")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Long id;
    private String dishName;
    @ManyToOne
    @JsonBackReference
    private CategoryEntity categoryId;
    private String description;
    private Integer price;
    @ManyToOne
    @JsonBackReference
    private RestaurantEntity restaurantId;
    private String urlImage;
    private Boolean active;

}
