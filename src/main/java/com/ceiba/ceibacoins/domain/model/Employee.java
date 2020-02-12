package com.ceiba.ceibacoins.domain.model;

import java.util.Date;

/**
 * Entidad de los empleados registrados de Ceiba
 *
 * @since 11/02/2020
 * @author sergio.portilla
 */
public class Employee {
    private Long nuip;

    private String employeeName;
    private String employeeLastName;

    private Date birthday;
    private Date entry;

    private Double ceibaCoins;
    private Boolean state;

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
