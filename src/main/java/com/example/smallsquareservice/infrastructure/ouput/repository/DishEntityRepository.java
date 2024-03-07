package com.example.smallsquareservice.infrastructure.ouput.repository;

import com.example.smallsquareservice.infrastructure.ouput.entity.CategoryEntity;
import com.example.smallsquareservice.infrastructure.ouput.entity.DishEntity;
import com.example.smallsquareservice.infrastructure.ouput.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DishEntityRepository extends JpaRepository<DishEntity,Long> {
    Optional<DishEntity> findByDishNameAndRestaurantId(String dishName, RestaurantEntity restaurant);
    Page<DishEntity> findAllByCategoryIdAndActive(CategoryEntity category, Boolean active , Pageable pageable);
}
