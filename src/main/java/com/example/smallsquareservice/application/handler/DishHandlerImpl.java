package com.example.smallsquareservice.application.handler;

import com.example.smallsquareservice.application.dto.DishRequest;
import com.example.smallsquareservice.application.dto.DishResponse;
import com.example.smallsquareservice.application.dto.DishResponseMenu;
import com.example.smallsquareservice.application.dto.DishUpdateRequest;
import com.example.smallsquareservice.application.mapper.DishMapper;
import com.example.smallsquareservice.domain.api.IDishServicePort;
import com.example.smallsquareservice.domain.model.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements IDishHandler{
    private final IDishServicePort dishServicePort;
    private final DishMapper dishMapper;
    @Override
    public DishResponse saveDish(DishRequest dishRequest) {
        Dish dish = dishMapper.toModelDish(dishRequest);
        return dishMapper.toResponse(dishServicePort.saveDish(dish));
    }
    @Override
    public DishResponse getDish(Long id) {
        Dish dish = dishServicePort.getDish(id);
        return dishMapper.toResponse(dish);
    }
    @Override
    public DishResponse updateDish(Long id, DishUpdateRequest dishUpdateRequest) {
        Dish dish = dishServicePort.getDish(id);
        dish.setPrice(dishUpdateRequest.getPrice());
        dish.setDescription(dishUpdateRequest.getDescription());
        return dishMapper.toResponse(dishServicePort.updateDish(dish));
    }
    @Override
    public DishResponse updateStatusDish(Long id) {
        Dish dish = dishServicePort.getDish(id);
        return dishMapper.toResponse(dishServicePort.updateStatusDish(dish));
    }

    @Override
    public Page<DishResponseMenu> getDishesByCategory(String category, int page, int size) {
        Page<Dish> dishes = dishServicePort.getDishes(category ,page, size);
        return dishes.map(dishMapper::toDishResponseMenu);
    }
}
