package com.example.smallsquareservice.application.mapper;

import com.example.smallsquareservice.application.dto.RestaurantRequest;
import com.example.smallsquareservice.application.dto.RestaurantResponse;
import com.example.smallsquareservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    Restaurant toModel(RestaurantRequest restaurantRequest);

    RestaurantResponse toResponse (Restaurant restaurant);

}
