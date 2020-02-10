package com.ceiba.ceibacoins.domain.model.validation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ValidationDateEmployee {

    public static Boolean isWeekDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    public static LocalDate convertDate(Date dateToConvert) {
        return ((Date) dateToConvert).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Boolean isBirthDay(LocalDate date, Date dateEmployee) {
        LocalDate birthEmployee = convertDate(dateEmployee);
        return date.getMonth() == birthEmployee.getMonth() && date.getDayOfMonth() == birthEmployee.getDayOfMonth();
    }

    public static Boolean isEntry(LocalDate date, Date dateEmployee) {
        return date == convertDate(dateEmployee);
    }
}
