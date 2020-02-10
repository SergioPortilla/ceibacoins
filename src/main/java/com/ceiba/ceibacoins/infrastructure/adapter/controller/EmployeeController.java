package com.ceiba.ceibacoins.infrastructure.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.application.caseuse.IEmployeeService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(path = "/ceibacoins")
public class EmployeeController {
	
	@Autowired
	public IEmployeeService employeeService;

	@GetMapping(path = "/all")
	public @ResponseBody List<Employee> getActiveEmployees() { return employeeService.findActive();}
	
	@PostMapping(path = "/create")
	public @ResponseBody String createEmployes(@RequestBody Employee employee){ return employeeService.create(employee, true);}

	@GetMapping(path = "/search/{nuip}")
	public @ResponseBody Employee retrieveEmployee(@PathVariable long nuip){ return employeeService.findById(nuip, LocalDate.now());}

	@PutMapping(path = "/update")
	public @ResponseBody String updateEmployes(@RequestBody Employee employee){ return employeeService.create(employee, false);}

	@PutMapping(path = "/update_coins")
	public @ResponseBody String updateEmployes(){ return employeeService.create(LocalDate.now());}

}
