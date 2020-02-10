package com.ceiba.ceibacoins.application.caseuse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.ceibacoins.domain.ports.IActivityRepository;
import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.domain.model.validation.ValidationDateEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.ceibacoins.domain.ports.IEmployeeRepository;
import com.ceiba.ceibacoins.domain.model.Employee;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Autowired
	private IActivityRepository activityRepository;

	@Override
	public String create(Employee employee, Boolean newEmployee) {
		try {
			if (newEmployee ^ (findById(employee.getNuip()) != null)){
				employeeRepository.save(employee);
				return newEmployee ? "Creado Exitosamente" : "Usuario Actualizado Exitosamente";
			} else {
				return newEmployee ? "El usuario ya existe" : "El usuario no existe";
			}
		} catch (Exception e) {
			return "Error: "+e.getMessage();
		}
	}

	@Override
	public String create(LocalDate date) {
		List<String> usersModify = new ArrayList<>();
		for (Employee employee : findActive()) {
			boolean modify = false;
			if (modify = ValidationDateEmployee.isBirthDay(date, employee.getBirthday()))
				employee.setCeibaCoins(+ activityRepository.findById(1L).orElse(new Activity()).getPrice());
			if (modify = modify || ValidationDateEmployee.isEntry(date, employee.getEntry()))
				employee.setCeibaCoins(+ activityRepository.findById(2L).orElse(new Activity()).getPrice());
			if (!modify)
				continue;
			create(employee, false);
			usersModify.add(employee.getEmployeeName());
		}
		return "Se agregaron CeibaCoins a: "+usersModify.toString();
	}
	
	@Override
	public List<Employee> findActive() {
		return employeeRepository.findActiveEmployees(true);
	}
	
	@Override
	public Employee findById(Long nuip) {
			return employeeRepository.findById(nuip).orElse(null);
	}

	@Override
	public Employee findById(Long nuip, LocalDate date) {
		if(ValidationDateEmployee.isWeekDay(date)) return findById(nuip); else return null;
	}

}
