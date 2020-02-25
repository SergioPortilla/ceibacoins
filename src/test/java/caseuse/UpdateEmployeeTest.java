package caseuse;

import builder.EmployeeTestDataBuilder;
import com.ceiba.ceibacoins.application.caseuse.FindEmployee;
import com.ceiba.ceibacoins.application.caseuse.UpdateEmployee;
import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.ports.ActivityRepository;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class UpdateEmployeeTest {

    private UpdateEmployee updateEmployee;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private FindEmployee findEmployee;

    @BeforeEach
    public void setup (){

        MockitoAnnotations.initMocks(this);
        this.updateEmployee = new UpdateEmployee(employeeRepository,activityRepository, findEmployee);

    }

    @Test
    void createTest(){

        Employee employee = new EmployeeTestDataBuilder()
                .withNuip(1213L).withName("prueba")
                .withLastName("casouso").withBorn(new Date())
                .withEntry(new Date()).withCoins(0.0)
                .withState(true).build();
        Boolean isNewEmployee = true;

        doNothing().when(this.employeeRepository).save(employee);
        when(this.findEmployee.findEmployeeById(1213L)).thenReturn(null);
        String createSuccess = this.updateEmployee.createEmployee(employee, isNewEmployee);

        Assertions.assertEquals("Creado Exitosamente", createSuccess);

    }

    @Test
    void coinsUpdateTest(){

        Employee employee = new EmployeeTestDataBuilder()
                .withNuip(1213L).withName("prueba")
                .withLastName("casouso").withBorn(new Date())
                .withEntry(new Date()).withCoins(0.0)
                .withState(true).build();
        employee.setEmployeeName("prueba");
        employee.setBirthday(new Date());
        employee.setEntry(new Date());
        employee.setCeibaCoins(0.0);
        Activity activity = new Activity();
        activity.setIdActivity(1L);
        activity.setName("Algo");
        activity.setPrice(0.0);
        LocalDate currentDate = LocalDate.now();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        when(this.activityRepository.findById(1L)).thenReturn(activity);
        when(this.activityRepository.findById(2L)).thenReturn(activity);
        when(this.findEmployee.findActiveEmployees()).thenReturn(employees);
        String result = this.updateEmployee.updateCoins(currentDate);

        Assertions.assertEquals("Se agregaron CeibaCoins a: [prueba]", result);
    }
}