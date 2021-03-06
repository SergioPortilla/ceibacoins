package com.ceiba.ceibacoins.domain.ports;

import com.ceiba.ceibacoins.domain.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);

    Employee findById(Long nuip);

    List<Employee> findByStateEmployees(Boolean state);
}
