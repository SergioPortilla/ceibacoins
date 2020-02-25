package com.ceiba.ceibacoins.application.caseuse;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.model.validation.ValidationDateEmployee;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FindEmployee {

    /** Inyeccion del repositorio de empleados */
    private final EmployeeRepository employeeRepository;

    public FindEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findActiveEmployees() {
        return employeeRepository.findByStateEmployees(true);
    }

    public Employee findEmployeeById(Long nuip) {
        return employeeRepository.findById(nuip);
    }

    public Employee findEmployeeById(Long nuip, LocalDate date) {
        if(ValidationDateEmployee.isWeekDay(date)) return findEmployeeById(nuip); else return null;
    }
}
