package com.example.smallsquareservice.infrastructure.ouput.adapter;

import com.example.smallsquareservice.domain.model.Restaurant;
import com.example.smallsquareservice.domain.spi.IRestaurantPersistencePort;
import com.example.smallsquareservice.infrastructure.client.UserClient;
import com.example.smallsquareservice.infrastructure.exception.*;
import com.example.smallsquareservice.infrastructure.ouput.entity.RestaurantEntity;
import com.example.smallsquareservice.infrastructure.ouput.entity.UserEntity;
import com.example.smallsquareservice.infrastructure.ouput.mapper.IRestaurantEntityMapper;
import com.example.smallsquareservice.infrastructure.ouput.repository.RestaurantEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantAdapter implements IRestaurantPersistencePort {

    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final RestaurantEntityRepository restaurantRepository;
    private final UserClient userClient;
    @Override
    public void saveRestaurant(Restaurant restaurant) {
        Optional<RestaurantEntity> nameValidation = restaurantRepository.findByNameRestaurant(restaurant.getNameRestaurant());
        Optional<RestaurantEntity> nitValidation = restaurantRepository.findByNit(restaurant.getNit());
        Optional<RestaurantEntity> addressValidation = restaurantRepository.findByAddress(restaurant.getAddress());
        UserEntity user = userClient.getUserById(restaurant.getOwnerId()).orElseThrow(DontExistUser::new);
        if (user.getRole().getId() != 1) throw new IncorrectRole();
        else if(nameValidation.isPresent()) throw new NameAlreadyRegistered();
        else if(nitValidation.isPresent()) throw new NitAlreadyRegistered();
        else if(addressValidation.isPresent()) throw new AddressAlreadyRegister();
        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }
    @Override
    public Page<Restaurant> getRestaurants(int page, int size) {
        Pageable pageable = PageRequest.of((page-1), size);
        Page<RestaurantEntity> restaurants = restaurantRepository.findAllByOrderByNameRestaurantAsc(pageable);
        return restaurants.map(restaurantEntityMapper::toModel);
    }
}
