package com.ceiba.ceibacoins.builder;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaEmployee;

import java.util.Calendar;
import java.util.Date;

public class EmployeeTestDataBuilder {

    private static final Long NUIP = 12345L;
    private static final String EMPLOYEENAME = "abcd";
    private static final String EMPLOYEELASTNAME = "fghi";
    private static final Date BORN = new Date(1994, Calendar.MAY, 12);
    private static final Date ENTRY = new Date(2019, Calendar.DECEMBER, 23);;
    private static final Double CEIBACOINS = 100000.0D;
    private static final Boolean STATE = Boolean.TRUE;

    public Long nuip;
    public String employeeName;
    public String employeeLastName;
    public Date born;
    public Date entry;
    public Double ceibaCoins;
    public Boolean state;

    public EmployeeTestDataBuilder() {
        this.nuip = NUIP;
        this.employeeName = EMPLOYEENAME;
        this.employeeLastName = EMPLOYEELASTNAME;
        this.born = BORN;
        this.entry = ENTRY;
        this.ceibaCoins = CEIBACOINS;
        this.state = STATE;
    }
    public Employee Build() {
        return new Employee(this.NUIP, this.EMPLOYEENAME, this.EMPLOYEELASTNAME, this.BORN, this.ENTRY, this.CEIBACOINS,this.STATE);
    }
}
