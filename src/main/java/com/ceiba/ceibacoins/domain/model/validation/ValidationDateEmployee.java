package com.ceiba.ceibacoins.domain.model.validation;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

/**
 * Validaciones necesarias para la creacion, verificacion y actualizacion de datos de los empleados.
 *
 * @since 08/02/2020
 * @author sergio.portilla
 */
public class ValidationDateEmployee {

    /**
     * Verificacion si es entre semana.
     *
     * @param date fecha en la cual se realizara la verificacion.
     * @return Si es entre semana obtiene el valor de verdadero, fin de semana falso.
     */
    public static Boolean isWeekDay(LocalDate date) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    /**
     * Convierte la fecha del empleado y la actividad a LocalDate para su manipulacion.
     *
     * @param dateToConvert fecha obtenida de base de datos
     * @return fecha convertida a LocalDate
     */
    public static LocalDate convertDate(Date dateToConvert) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return LocalDate.parse(format.format(dateToConvert));
    }

    /**
     * Verifica si un usuario cumple años en la fecha indicada.
     *
     * @param date fecha en la cual se realiza la consulta
     * @param dateEmployee fecha de nacimiento del empleado
     * @return Si el usuario cumple años retorna el valor verdadero, de lo contrario es falso.
     */
    public static Boolean isBirthDay(LocalDate date, Date dateEmployee) {
        LocalDate birthEmployee = convertDate(dateEmployee);
        return date.getMonth() == birthEmployee.getMonth() && date.getDayOfMonth() == birthEmployee.getDayOfMonth();
    }

    /**
     * Verifica si el usuario ingreso la fecha indicada.
     *
     * @param date fecha en la cual se realiza la consulta
     * @param dateEmployee fecha de ingreso del empleado
     * @return Si el usuario ingresa el dia indicado retorna el valor verdadero, de lo contrario es falso
     */
    public static Boolean isEntry(LocalDate date, Date dateEmployee) {
        return date.equals(convertDate(dateEmployee));
    }
}
