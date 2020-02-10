package com.ceiba.ceibacoins.application.caseuse;

import com.ceiba.ceibacoins.builder.EmployeeTestDataBuilder;
import com.ceiba.ceibacoins.domain.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    public IEmployeeService employeeService = new EmployeeService();

    @Mock
    private Employee employee;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
//    @BeforeEach
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//        this.employeeService.create(employee, true);
//    }

//    @BeforeEach
//    void setUp() {
//        List mockedList = mock(List.class);
////        Employee mockedList = mock(Employee.class);
//        //using mock object
//        mockedList. add("one");
//        mockedList.clear();
//        //verification
//        verify(mockedList).add("one");
//        verify(mockedList).clear();
//    }


    @Test
    void testCreate() {
        // arrange
        Employee employee = new EmployeeTestDataBuilder().Build();
        // act
        String result = this.employeeService.create(employee,true) ;
        // assert
        assertEquals("Creado Exitosamente",result);
    }

    @Test
    void findActive() {

    }

    @Test
    void findById() {
    }

    @Test
    void testFindById() {
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