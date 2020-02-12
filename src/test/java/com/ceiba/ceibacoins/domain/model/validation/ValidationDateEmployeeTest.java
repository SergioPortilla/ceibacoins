package com.ceiba.ceibacoins.domain.model.validation;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ValidationDateEmployeeTest {

    @Test
    void isWeekendTest() {
        LocalDate someSunday = LocalDate.of(2020, 2, 2);

        Boolean isWeekeend = ValidationDateEmployee.isWeekDay(someSunday);

        assertFalse(isWeekeend);
    }

    @Test
    void isWeekDayTest() {
        LocalDate someMonday = LocalDate.of(2020, 2, 3);

        Boolean isWeekDay = ValidationDateEmployee.isWeekDay(someMonday);

        assertTrue(isWeekDay);
    }

    @Test
    void convertDateTest() {
        Date currentDateD = new Date();
        LocalDate currentDateLD = LocalDate.now();

        LocalDate conversion = ValidationDateEmployee.convertDate(currentDateD);

        assertEquals(currentDateLD, conversion);
    }

    @Test
    void isBirthDayTest() {

        Date currentDateD = new Date();
        LocalDate currentDateLD = LocalDate.now();

        Boolean isBirthday = ValidationDateEmployee.isBirthDay(currentDateLD, currentDateD);

        assertTrue(isBirthday);
    }

    @Test
    void isNotBirthDayTest() {

        Date currentDateD = new Date(1994, Calendar.MAY, 12);;
        LocalDate currentDateLD = LocalDate.now();

        Boolean isBirthday = ValidationDateEmployee.isBirthDay(currentDateLD, currentDateD);

        assertFalse(isBirthday);
    }

    @Test
    void isEntryTodayTest() {
        Date currentDateD = new Date();
        LocalDate currentDateLD = LocalDate.now();

        Boolean entryToday = ValidationDateEmployee.isEntry(currentDateLD, currentDateD);

        assertTrue(entryToday);
    }

    @Test
    void isNotEntryTest() {
        Date currentDateD = new Date(2019, 5, 12);
        LocalDate currentDateLD = LocalDate.of(2020, 3, 4);

        Boolean entryToday = ValidationDateEmployee.isEntry(currentDateLD, currentDateD);

        assertFalse(entryToday);
    }
}