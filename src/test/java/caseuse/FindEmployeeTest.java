package caseuse;

import builder.EmployeeTestDataBuilder;
import com.ceiba.ceibacoins.application.caseuse.FindEmployee;
import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindEmployeeTest {

    private FindEmployee findEmployee;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup (){
        MockitoAnnotations.initMocks(this);
        this.findEmployee = new FindEmployee(employeeRepository);
    }

    @Test
    void FindByIdTest(){

        Employee employee = new EmployeeTestDataBuilder()
                .withNuip(1213L).withName("prueba")
                .withLastName("casouso").withBorn(new Date())
                .withEntry(new Date()).withCoins(0.0)
                .withState(true).build();

        when(this.employeeRepository.findById(1213L)).thenReturn(employee);
        Employee found = this.findEmployee.findEmployeeById(1213L);

        Assertions.assertEquals(employee, found);

    }

    @Test
    void findByIdWeekDayTest () {

        Employee employee = new EmployeeTestDataBuilder()
                .withNuip(1213L).withName("prueba")
                .withLastName("casouso").withBorn(new Date())
                .withEntry(new Date()).withCoins(0.0)
                .withState(true).build();
        LocalDate someMonday = LocalDate.of(2020, 2, 3);

        when(this.employeeRepository.findById(1213L)).thenReturn(employee);
        Employee found = this.findEmployee.findEmployeeById(1213L, someMonday);

        Assertions.assertEquals(employee, found);

    }

    @Test
    void findByIdWeekendTest () {

        Employee employee = new EmployeeTestDataBuilder()
                .withNuip(1213L).withName("prueba")
                .withLastName("casouso").withBorn(new Date())
                .withEntry(new Date()).withCoins(0.0)
                .withState(true).build();
        LocalDate someSunday = LocalDate.of(2020, 2, 2);

        when(this.employeeRepository.findById(1213L)).thenReturn(employee);
        Employee found = this.findEmployee.findEmployeeById(1213L, someSunday);

        Assert.assertNull(found);

    }

    @Test
    void findActiveEmployeesTest() {

        Employee employee = new EmployeeTestDataBuilder()
                .withNuip(1213L).withName("prueba")
                .withLastName("casouso").withBorn(new Date())
                .withEntry(new Date()).withCoins(0.0)
                .withState(true).build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        when(this.employeeRepository.findByStateEmployees(true)).thenReturn(employees);
        List<Employee> EmployeesFound = this.findEmployee.findActiveEmployees();

        Assertions.assertEquals(employees, EmployeesFound);

    }
}