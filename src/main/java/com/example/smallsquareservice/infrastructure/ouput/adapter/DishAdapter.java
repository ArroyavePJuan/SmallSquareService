package com.example.smallsquareservice.infrastructure.ouput.adapter;

import com.example.smallsquareservice.domain.model.Dish;
import com.example.smallsquareservice.domain.spi.IDishPersistencePort;
import com.example.smallsquareservice.infrastructure.client.UserClient;
import com.example.smallsquareservice.infrastructure.exception.*;
import com.example.smallsquareservice.infrastructure.ouput.entity.CategoryEntity;
import com.example.smallsquareservice.infrastructure.ouput.entity.DishEntity;
import com.example.smallsquareservice.infrastructure.ouput.entity.RestaurantEntity;
import com.example.smallsquareservice.infrastructure.ouput.entity.UserEntity;
import com.example.smallsquareservice.infrastructure.ouput.mapper.IDishEntityMapper;
import com.example.smallsquareservice.infrastructure.ouput.repository.CategoryEntityRepository;
import com.example.smallsquareservice.infrastructure.ouput.repository.DishEntityRepository;
import com.example.smallsquareservice.infrastructure.ouput.repository.RestaurantEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@RequiredArgsConstructor
public class DishAdapter implements IDishPersistencePort {

    private final IDishEntityMapper dishEntityMapper;
    private final DishEntityRepository dishEntityRepository;
    private final RestaurantEntityRepository restaurantEntityRepository;
    private final CategoryEntityRepository categoryEntityRepository;
    private final UserClient userClient;

    @Override
    public Dish saveDish(Dish dish) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userClient.getUserByEmail(authentication.getName()).orElseThrow(UserNotFound::new);
        RestaurantEntity restaurant = restaurantEntityRepository.findById(dish.getRestaurantId()).orElseThrow(RestaurantNotFound::new);
        Optional<CategoryEntity> categoryEntity = categoryEntityRepository.findById(dish.getCategoryId());
        Optional<DishEntity> dishEntity = dishEntityRepository.findByDishNameAndRestaurantId(dish.getDishName(),restaurant);
        if(categoryEntity.isEmpty())throw new CategoryNotFound();
        else if(dishEntity.isPresent()) throw new DishAlreadyRegistered();
        else if(!user.getId().equals(restaurant.getOwnerId())) throw new InvalidOwner();
        return dishEntityMapper.toModel(dishEntityRepository.save(dishEntityMapper.toEntity(dish)));
    }
    @Override
    public Dish getDish(Long id) {
        DishEntity dishEntity = dishEntityRepository.findById(id).orElseThrow(DishNotFound::new);
        return dishEntityMapper.toModel(dishEntity);
    }
    @Override
    public Dish updateDish(Dish dish) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity user = userClient.getUserByEmail(authentication.getName()).orElseThrow(UserNotFound::new);
        RestaurantEntity restaurant = restaurantEntityRepository.findById(dish.getRestaurantId()).orElseThrow(RestaurantNotFound::new);
        if(!user.getId().equals(restaurant.getOwnerId())) throw new InvalidOwner();
        return dishEntityMapper.toModel(dishEntityRepository.save(dishEntityMapper.toEntity(dish)));
    }
    @Override
    public Page<Dish> getRestaurants(String category, int page, int size) {
        Pageable pageable = PageRequest.of((page-1), size);
        CategoryEntity searchCategory = categoryEntityRepository.findByCategoryName(category).orElseThrow(CategoryNotFound::new);
        Page<DishEntity> dishEntities = dishEntityRepository.findAllByCategoryIdAndActive(searchCategory, true, pageable);
        return dishEntities.map(dishEntityMapper::toModel);
    }

}
