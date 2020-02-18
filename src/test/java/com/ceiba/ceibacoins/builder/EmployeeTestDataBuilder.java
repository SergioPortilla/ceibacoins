package com.ceiba.ceibacoins.builder;

import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.jpaentity.JpaEmployee;

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

    private Long nuip;
    private String employeeName;
    private String employeeLastName;
    private Date born;
    private Date entry;
    private Double ceibaCoins;
    private Boolean state;

    public EmployeeTestDataBuilder() {
        this.nuip = NUIP;
        this.employeeName = EMPLOYEENAME;
        this.employeeLastName = EMPLOYEELASTNAME;
        this.born = BORN;
        this.entry = ENTRY;
        this.ceibaCoins = CEIBACOINS;
        this.state = STATE;
    }
    public JpaEmployee Build() {
        return new JpaEmployee(this.nuip, this.employeeName, this.employeeLastName, this.born, this.entry, this.ceibaCoins,this.state);
    }
}
