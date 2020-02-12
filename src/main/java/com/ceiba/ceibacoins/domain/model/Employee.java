package com.ceiba.ceibacoins.domain.model;

import java.util.Date;

/**
 * Entidad de los empleados registrados de Ceiba
 *
 * @since 11/02/2020
 * @author sergio.portilla
 */
public class Employee {
    /** Numero unico de identificacion personal*/
    private Long nuip;

    /** Nombre del empleado */
    private String employeeName;

    /**	Apellido del empleado */
    private String employeeLastName;

    /**	Dia de nacimiento */
    private Date birthday;

    /**	Dia de ingreso a Ceiba */
    private Date entry;

    /**	Cantidad de ceibaCoins obtenidos por el empleado */
    private Double ceibaCoins;

    /** Estado del empleado, si se encuentra en la empresa o no */
    private Boolean state;

    /** Constructor vacio */
    public Employee() {
    }

    public Long getNuip() {
        return nuip;
    }

    public void setNuip(Long nuip) {
        this.nuip = nuip;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public Double getCeibaCoins() {
        return ceibaCoins;
    }

    public void setCeibaCoins(Double ceibaCoins) {
        this.ceibaCoins = ceibaCoins;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
