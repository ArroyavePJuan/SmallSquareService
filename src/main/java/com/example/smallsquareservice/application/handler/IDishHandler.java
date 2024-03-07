package com.example.smallsquareservice.application.handler;

import com.example.smallsquareservice.application.dto.DishRequest;
import com.example.smallsquareservice.application.dto.DishResponse;
import com.example.smallsquareservice.application.dto.DishResponseMenu;
import com.example.smallsquareservice.application.dto.DishUpdateRequest;
import org.springframework.data.domain.Page;



public interface IDishHandler {
    DishResponse saveDish(DishRequest dishRequest);
    DishResponse getDish(Long id);
    DishResponse updateDish(Long id, DishUpdateRequest dishUpdateRequest);
    DishResponse updateStatusDish(Long id);
    Page<DishResponseMenu> getDishesByCategory(String category, int page, int size);
}
