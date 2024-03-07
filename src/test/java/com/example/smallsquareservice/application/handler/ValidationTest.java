package com.example.smallsquareservice.application.handler;

import com.example.smallsquareservice.application.dto.RestaurantRequest;
import com.example.smallsquareservice.domain.model.Restaurant;
import com.example.smallsquareservice.domain.usecase.validation.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {


    @Test
    void testEmptyFields() {
        Restaurant validRequest = new Restaurant("casa","direccion",1L,"1231","asdasd","1231232");
        assertFalse(Validation.emptyFields(validRequest));

        Restaurant invalidRequest = new Restaurant("", "direccion",2L, "1234567890", "httplogo","123123123");
        assertTrue(Validation.emptyFields(invalidRequest));
    }

    @Test
    void testVeryLongNumber() {
        assertFalse(Validation.veryLongNumber("1234567890123"));
        assertTrue(Validation.veryLongNumber("12345678901234"));
    }

    @Test
    void testPhoneStructure() {
        assertFalse(Validation.phoneStructure("+1234567890"));
        assertFalse(Validation.phoneStructure("1234567890"));
    }
    @Test
    void testWrongPhoneStructure(){
        assertTrue(Validation.phoneStructure("+123fasf12"));
    }

    @Test
    void testValidateNit() {
        assertTrue(Validation.validateNit("asfda"));
        assertTrue(Validation.validateNit("123gfa12"));
        assertFalse(Validation.validateNit("123"));
    }

    @Test
    void testValidateRestaurantName() {
        assertTrue(Validation.validateRestaurantName("123"));
        assertFalse(Validation.validateRestaurantName("El Corral"));
        assertFalse(Validation.validateRestaurantName("El corral 3"));
    }
    @Test
    void testInvalidNumbers(){
        assertFalse(Validation.negativeNumbers(1,4));
        assertTrue(Validation.negativeNumbers(0,2));
        assertTrue(Validation.negativeNumbers(-2,0));
    }
}