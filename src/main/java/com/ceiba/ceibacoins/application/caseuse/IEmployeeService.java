package com.ceiba.ceibacoins.application.caseuse;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.ceibacoins.domain.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> findActive();
	
	public Employee findById(Long nuip);

	public Employee findById(Long nuip, LocalDate date);
	
	public String create(Employee employee, Boolean newEmployee);

	public String create(LocalDate date);

}
