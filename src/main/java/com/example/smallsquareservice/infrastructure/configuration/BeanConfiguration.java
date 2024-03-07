package com.example.smallsquareservice.infrastructure.configuration;

import com.example.smallsquareservice.domain.api.IDishServicePort;
import com.example.smallsquareservice.domain.api.IRestaurantServicePort;
import com.example.smallsquareservice.domain.spi.IDishPersistencePort;
import com.example.smallsquareservice.domain.spi.IRestaurantPersistencePort;
import com.example.smallsquareservice.domain.usecase.DishUseCase;
import com.example.smallsquareservice.domain.usecase.RestaurantUseCase;
import com.example.smallsquareservice.infrastructure.client.UserClient;
import com.example.smallsquareservice.infrastructure.ouput.adapter.DishAdapter;
import com.example.smallsquareservice.infrastructure.ouput.adapter.RestaurantAdapter;
import com.example.smallsquareservice.infrastructure.ouput.mapper.IDishEntityMapper;
import com.example.smallsquareservice.infrastructure.ouput.mapper.IRestaurantEntityMapper;
import com.example.smallsquareservice.infrastructure.ouput.repository.CategoryEntityRepository;
import com.example.smallsquareservice.infrastructure.ouput.repository.DishEntityRepository;
import com.example.smallsquareservice.infrastructure.ouput.repository.RestaurantEntityRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final RestaurantEntityRepository restaurantEntityRepository;
    private final UserClient userClient;
    private final IDishEntityMapper dishEntityMapper;
    private final DishEntityRepository dishEntityRepository;
    private final CategoryEntityRepository categoryEntityRepository;


    @Bean
    public IRestaurantPersistencePort userPersistencePort() {
        return new RestaurantAdapter(restaurantEntityMapper, restaurantEntityRepository,userClient);
    }
    @Bean
    public IRestaurantServicePort userServicePort() {
        return new RestaurantUseCase(userPersistencePort());
    }
    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishAdapter(dishEntityMapper,dishEntityRepository,restaurantEntityRepository,categoryEntityRepository,userClient);
    }
    @Bean
    public IDishServicePort dishServicePort() {
        return new DishUseCase(dishPersistencePort());
    }
}
