package com.example.smallsquareservice.infrastructure.ouput.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "restaurant")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;
    private String nameRestaurant;
    private String address;
    private Long ownerId;
    private String phone;
    private String urlLogo;
    private String nit;
    @OneToMany(mappedBy = "restaurantId")
    @JsonManagedReference
    @JsonIgnore
    private List<DishEntity> dishEntities;

}
