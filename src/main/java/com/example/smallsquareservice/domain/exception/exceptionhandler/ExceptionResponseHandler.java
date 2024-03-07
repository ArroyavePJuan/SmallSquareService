package com.example.smallsquareservice.domain.exception.exceptionhandler;

public enum ExceptionResponseHandler {

    EMPTY_FIELDS("You must fill in all the fields"),
    INVALID_PHONE_STRUCTURE("only numbers are accepted after the +"),
    NAME_WRONG("You cannot enter a name with only numbers"),
    NIT_WRONG("The NIT can only contain numbers"),
    PHONE_WRONG("The phone number exceeds 13 characters"),
    INVALID_PRICE("Price must be greater than 0"),
    INVALID_PAGE("Numbers less than 0 are not allowed.")
    ;

    private String message;

    ExceptionResponseHandler(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }


}
