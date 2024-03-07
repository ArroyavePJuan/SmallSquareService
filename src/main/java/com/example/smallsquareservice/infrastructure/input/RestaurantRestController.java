package com.example.smallsquareservice.infrastructure.input;

import com.example.smallsquareservice.application.dto.RestaurantRequest;
import com.example.smallsquareservice.application.dto.RestaurantResponse;
import com.example.smallsquareservice.application.handler.IRestaurantHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/")
@RequiredArgsConstructor
public class RestaurantRestController {

    private final IRestaurantHandler restaurantHandler;
    @PostMapping
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantRequest restaurantRequest){
        restaurantHandler.saveRestaurant(restaurantRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("findRestaurant")
    public ResponseEntity<List<RestaurantResponse>> findRestaurants(
            @RequestParam int size,
            @RequestParam int page
    ) {
        Page<RestaurantResponse> dataPage = restaurantHandler.getRestaurants(page, size);
        List<RestaurantResponse> dataList = dataPage.getContent();
        return ResponseEntity.ok().body(dataList);
    }

}
