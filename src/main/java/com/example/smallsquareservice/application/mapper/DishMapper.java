package com.example.smallsquareservice.application.mapper;

import com.example.smallsquareservice.application.dto.DishRequest;
import com.example.smallsquareservice.application.dto.DishResponse;
import com.example.smallsquareservice.application.dto.DishResponseMenu;
import com.example.smallsquareservice.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DishMapper {

    Dish toModelDish(DishRequest dishRequest);
    DishResponse toResponse(Dish dish);
    List<DishResponse> toResponseList(List<Dish> dishes);
    DishResponseMenu toDishResponseMenu(Dish dish);
}
