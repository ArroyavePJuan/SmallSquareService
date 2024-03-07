package com.example.smallsquareservice.infrastructure.exceptionhandler;

public enum ExceptionResponse {

    NAME_ALREADY_REGISTERED("This name is already registered"),
    NIT_ALREADY_REGISTERED("This nit is already registered"),
    INCORRECT_ROLE("Only owners can create restaurants"),
    DONT_EXIST_USER("This user does not exist"),
    ADDRESS_ALREADY_REGISTER("This address is already registered"),
    OWNER_ALREADY_REGISTERED("This owner already has a restaurant"),
    CATEGORY_NOT_FOUND("This category does not exist"),
    DISH_ALREADY_REGISTERED("This dish is already registered in this restaurant"),
    RESTAURANT_NOT_FOUND("This restaurant does not exist"),
    INVALID_OWNER("This owner cannot add create dishes at this restaurant"),
    DISH_NOT_FOUND("This dish does not exist"),
    USER_NOT_FOUND("this user was not found")
    ;

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
