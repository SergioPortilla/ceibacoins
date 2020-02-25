package builder;

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

    public Employee build() {
        return new Employee(this.nuip, this.employeeName, this.employeeLastName, this.born, this.entry, this.ceibaCoins ,this.state);
    }

    public EmployeeTestDataBuilder withNuip(Long nuip) {
        this.nuip = nuip;
        return this;
    }

    public EmployeeTestDataBuilder withName(String name) {
        this.employeeName = name;
        return this;
    }

    public EmployeeTestDataBuilder withLastName(String lastName) {
        this.employeeLastName = lastName;
        return this;
    }

    public EmployeeTestDataBuilder withBorn(Date born) {
        this.born = born;
        return this;
    }

    public EmployeeTestDataBuilder withEntry(Date entry) {
        this.entry = entry;
        return this;
    }

    public EmployeeTestDataBuilder withCoins(Double ceibacoins) {
        this.ceibaCoins = ceibacoins;
        return this;
    }

    public EmployeeTestDataBuilder withState(Boolean state) {
        this.state = state;
        return this;
    }
}
