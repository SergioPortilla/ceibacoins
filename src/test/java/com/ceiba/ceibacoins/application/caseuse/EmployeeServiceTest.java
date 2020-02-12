package com.ceiba.ceibacoins.application.caseuse;

import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto.EmployeeDTO;
import com.ceiba.ceibacoins.domain.ports.IEmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class EmployeeServiceTest {

    private EmployeeDTO employee;
    private IEmployeeService employeeServices = new EmployeeService();

    @Mock
    private IEmployeeRepository employeeRepository;

    @Mock
    private IEmployeeService employeeService = new EmployeeService();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        // arrange
//        Employee employee = new EmployeeTestDataBuilder().Build();
//        Mockito.doReturn(null).when(employeeService).findById(employee.getNuip());
//        Mockito.doReturn(null).when(employeeRepository).save(employee);
        // act

//        String result = employeeServices.create(employee,true);
        // assert
//        assertEquals("Creado Exitosamente",result);
    }

    @Test
    void findActive() {

    }

    @Test
    void testFindById() {
        // arrange
//        Employee employee = new EmployeeTestDataBuilder().Build();
        // act
//        Mockito.doReturn(employee).when(employeeRepository).findById(employee.getNuip());
//        Employee employeeRecibe = employeeServices.findById(employee.getNuip());
        // assert
//        assertEquals(employee,employeeRecibe);
    }


    @Test
    void testFindActive() {
    }

    @Test
    void testFindById1() {
    }

    @Test
    void testFindById2() {
    }
}