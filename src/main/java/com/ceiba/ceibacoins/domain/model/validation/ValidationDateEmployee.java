package com.ceiba.ceibacoins.domain.model.validation;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class ValidationDateEmployee {

    public static Boolean isWeekDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    public static LocalDate convertDate(Date dateToConvert) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return LocalDate.parse(format.format(dateToConvert));
    }

    public static Boolean isBirthDay(LocalDate date, Date dateEmployee) {
        LocalDate birthEmployee = convertDate(dateEmployee);
        return date.getMonth() == birthEmployee.getMonth() && date.getDayOfMonth() == birthEmployee.getDayOfMonth();
    }

    public static Boolean isEntry(LocalDate date, Date dateEmployee) {
        return date.equals(convertDate(dateEmployee));
    }
}
