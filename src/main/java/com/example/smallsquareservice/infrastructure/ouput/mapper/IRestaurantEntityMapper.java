package com.example.smallsquareservice.infrastructure.ouput.mapper;


import com.example.smallsquareservice.domain.model.Restaurant;
import com.example.smallsquareservice.infrastructure.ouput.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {

    RestaurantEntity toEntity(Restaurant restaurant);
    Restaurant toModel (RestaurantEntity restaurantEntity);

}
