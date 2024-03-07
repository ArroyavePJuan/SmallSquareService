package com.example.smallsquareservice.domain.usecase;

import com.example.smallsquareservice.domain.api.IDishServicePort;
import com.example.smallsquareservice.domain.exception.EmptyFields;
import com.example.smallsquareservice.domain.exception.InvalidPage;
import com.example.smallsquareservice.domain.exception.InvalidPrice;
import com.example.smallsquareservice.domain.model.Dish;
import com.example.smallsquareservice.domain.spi.IDishPersistencePort;
import com.example.smallsquareservice.domain.usecase.validation.DishValidation;
import com.example.smallsquareservice.domain.usecase.validation.Validation;
import org.springframework.data.domain.Page;


public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public Dish saveDish(Dish dish) {
        if (DishValidation.emptyFields(dish)) throw new EmptyFields();
        else if (DishValidation.invalidPrice(dish.getPrice())) throw new InvalidPrice();
        dish.setActive(true);
        return dishPersistencePort.saveDish(dish);
    }

    @Override
    public Dish getDish(Long id) {
        return dishPersistencePort.getDish(id);
    }

    @Override
    public Dish updateDish(Dish dish) {
        if (DishValidation.emptyFields(dish)) throw new EmptyFields();
        else if (DishValidation.invalidPrice(dish.getPrice())) throw new InvalidPrice();
        return dishPersistencePort.updateDish(dish);
    }

    @Override
    public Dish updateStatusDish(Dish dish) {
        dish.setActive(!dish.getActive());
        return dishPersistencePort.updateDish(dish);
    }

    @Override
    public Page<Dish> getDishes(String category, int page, int size) {
        if (Validation.negativeNumbers(page,size)) throw new InvalidPage();
        return dishPersistencePort.getRestaurants(category,page, size);
    }

}
