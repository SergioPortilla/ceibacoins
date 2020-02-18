package com.ceiba.ceibacoins.application.caseuse;

import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.jpaentity.JpaEmployee;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class EmployeeServiceTest {

    private JpaEmployee employee;
    private EmployeeService employeeServices = new EmployeeService();

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeService employeeService = new EmployeeService();

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

}