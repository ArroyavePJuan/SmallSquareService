package com.example.smallsquareservice.infrastructure.input;

import com.example.smallsquareservice.application.dto.*;
import com.example.smallsquareservice.application.handler.IDishHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish/")
@RequiredArgsConstructor
public class DishRestController {

    private final IDishHandler dishHandler;
    @PostMapping
    public ResponseEntity<DishResponse> saveDish(@RequestBody DishRequest dishRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(dishHandler.saveDish(dishRequest));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<DishResponse> updateDish(@PathVariable Long id, @RequestBody DishUpdateRequest dishUpdateRequest){
        return ResponseEntity.status(HttpStatus.OK).body(dishHandler.updateDish(id, dishUpdateRequest));
    }
    @PutMapping("status/{id}")
    public ResponseEntity<DishResponse> updateStatusDish(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(dishHandler.updateStatusDish(id));
    }
    @GetMapping("findMenu")
    public ResponseEntity<List<DishResponseMenu>> findDishByCategory(
            @RequestParam String category,
            @RequestParam int page,
            @RequestParam int size
    ){
        Page<DishResponseMenu> dataPage = dishHandler.getDishesByCategory(category, page, size);
        List<DishResponseMenu> dataList = dataPage.getContent();
        return ResponseEntity.ok().body(dataList);
    }
}
