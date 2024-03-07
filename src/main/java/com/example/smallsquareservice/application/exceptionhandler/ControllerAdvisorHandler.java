package com.example.smallsquareservice.application.exceptionhandler;

import com.example.smallsquareservice.domain.exception.*;
import com.example.smallsquareservice.domain.exception.exceptionhandler.ExceptionResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice

public class ControllerAdvisorHandler {
    private static final String MESSAGE = "Message";

    @ExceptionHandler(EmptyFields.class)
    public ResponseEntity<Map<String, String>> emptyFields(
            EmptyFields emptyFields) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.EMPTY_FIELDS.getMessage()));
    }
    @ExceptionHandler(InvalidPhoneStructure.class)
    public ResponseEntity<Map<String, String>> invalidPhoneStructure(
            InvalidPhoneStructure invalidPhoneStructure) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.INVALID_PHONE_STRUCTURE.getMessage()));
    }
    @ExceptionHandler(NameWithOnlyNumbers.class)
    public ResponseEntity<Map<String, String>> nameWithOnlyNumbers(
            NameWithOnlyNumbers nameWithOnlyNumbers) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.NAME_WRONG.getMessage()));
    }
    @ExceptionHandler(NitWithLetters.class)
    public ResponseEntity<Map<String, String>> nitWithLetters(
            NitWithLetters nitWithLetters) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.NIT_WRONG.getMessage()));
    }
    @ExceptionHandler(VeryLongPhoneNumber.class)
    public ResponseEntity<Map<String, String>> veryLongPhoneNumber(
            VeryLongPhoneNumber veryLongPhoneNumber) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.PHONE_WRONG.getMessage()));
    }
    @ExceptionHandler(InvalidPrice.class)
    public ResponseEntity<Map<String, String>> invalidPrice(
            InvalidPrice invalidPrice) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.INVALID_PRICE.getMessage()));
    }
    @ExceptionHandler(InvalidPage.class)
    public ResponseEntity<Map<String, String>> invalidPage(
            InvalidPage invalidPage) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponseHandler.INVALID_PAGE.getMessage()));
    }
}
