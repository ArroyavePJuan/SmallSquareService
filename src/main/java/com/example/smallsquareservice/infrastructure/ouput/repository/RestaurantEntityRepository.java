package com.example.smallsquareservice.infrastructure.ouput.repository;

import com.example.smallsquareservice.infrastructure.ouput.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantEntityRepository extends JpaRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByNameRestaurant(String nameRestaurant);
    Optional<RestaurantEntity> findByNit(String nit);
    Optional<RestaurantEntity> findByAddress(String address);
    Optional<RestaurantEntity> findByOwnerId(Long ownerId);
    Page<RestaurantEntity> findAllByOrderByNameRestaurantAsc(Pageable pageable);
}