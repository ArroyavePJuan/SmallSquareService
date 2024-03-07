package com.example.smallsquareservice.infrastructure.exceptionhandler;

import com.example.smallsquareservice.infrastructure.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(NameAlreadyRegistered.class)
    public ResponseEntity<Map<String, String>> nameAlreadyRegistered(
            NameAlreadyRegistered nameAlreadyRegistered) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NAME_ALREADY_REGISTERED.getMessage()));
    }
    @ExceptionHandler(NitAlreadyRegistered.class)
    public ResponseEntity<Map<String, String>> nitAlreadyRegistered(
            NitAlreadyRegistered nitAlreadyRegistered) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NIT_ALREADY_REGISTERED.getMessage()));
    }
    @ExceptionHandler(IncorrectRole.class)
    public ResponseEntity<Map<String, String>> incorrectRole(
            IncorrectRole incorrectRole) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INCORRECT_ROLE.getMessage()));
    }
    @ExceptionHandler(DontExistUser.class)
    public ResponseEntity<Map<String, String>> dontExistUser(
            DontExistUser dontExistUser) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DONT_EXIST_USER.getMessage()));
    }
    @ExceptionHandler(AddressAlreadyRegister.class)
    public ResponseEntity<Map<String, String>> addressAlreadyRegister(
            AddressAlreadyRegister addressAlreadyRegister) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.ADDRESS_ALREADY_REGISTER.getMessage()));
    }
    @ExceptionHandler(OwnerAlreadyRegistered.class)
    public ResponseEntity<Map<String, String>> ownerAlreadyRegistered(
            OwnerAlreadyRegistered ownerAlreadyRegistered) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.OWNER_ALREADY_REGISTERED.getMessage()));
    }
    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<Map<String, String>> categoryNotFound(
            CategoryNotFound categoryNotFound) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.CATEGORY_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(DishAlreadyRegistered.class)
    public ResponseEntity<Map<String, String>> dishAlreadyRegistered(
            DishAlreadyRegistered dishAlreadyRegistered) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DISH_ALREADY_REGISTERED.getMessage()));
    }
    @ExceptionHandler(RestaurantNotFound.class)
    public ResponseEntity<Map<String, String>> restaurantNotFound(
            RestaurantNotFound restaurantNotFound) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.RESTAURANT_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(InvalidOwner.class)
    public ResponseEntity<Map<String, String>> invalidOwner(
            InvalidOwner invalidOwner) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.INVALID_OWNER.getMessage()));
    }
    @ExceptionHandler(DishNotFound.class)
    public ResponseEntity<Map<String, String>> dishNotFound(
            DishNotFound dishNotFound) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.DISH_NOT_FOUND.getMessage()));
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Map<String, String>> userNotFound(
            UserNotFound userNotFound) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }
}
