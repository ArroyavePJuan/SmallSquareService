package com.example.smallsquareservice.infrastructure.ouput.repository;

import com.example.smallsquareservice.infrastructure.ouput.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
