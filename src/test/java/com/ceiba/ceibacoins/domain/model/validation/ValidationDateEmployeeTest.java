package com.ceiba.ceibacoins.domain.model.validation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValidationDateEmployeeTest {

    @Test
    void isWeekDayTest() {
    }

    @Test
    void convertDateTest() {
        // arrange
        Date currentDateD = new Date();
        LocalDate currentDateLD = LocalDate.now();
        // act
        LocalDate conversion = ValidationDateEmployee.convertDate(currentDateD);
        // assert
        assertEquals(currentDateLD, conversion);
    }

    @Test
    void isBirthDayTest() {
        // arrange
        Date currentDateD = new Date();
        LocalDate currentDateLD = LocalDate.now();
        // act
        Boolean isBirthday = ValidationDateEmployee.isBirthDay(currentDateLD, currentDateD);
        // assert
        assertTrue(isBirthday);
    }

    @Test
    void isEntryTest() {
    }
}