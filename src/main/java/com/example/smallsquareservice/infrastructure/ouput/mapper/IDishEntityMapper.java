package com.example.smallsquareservice.infrastructure.ouput.mapper;

import com.example.smallsquareservice.domain.model.Dish;
import com.example.smallsquareservice.infrastructure.ouput.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDishEntityMapper {

    @Mapping(source = "categoryId", target = "categoryId.id")
    @Mapping(source = "restaurantId", target = "restaurantId.id")
    DishEntity toEntity(Dish dish);
    @Mapping(source = "categoryId.id",target = "categoryId")
    @Mapping(source = "restaurantId.id",target = "restaurantId")
    Dish toModel(DishEntity dishEntity);
    List<Dish> toDishes(List<Dish> dishes);

}
