package com.ceiba.ceibacoins.infrastructure.adapter.controller;

import com.ceiba.ceibacoins.domain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ceiba.ceibacoins.application.caseuse.IEmployeeService;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller que obtiene todas las peticiones realizadas al aplicativo.
 *
 * @since 08/02/2020
 * @author sergio.portilla
 */
@Controller
@RequestMapping(path = "/ceibacoins")
public class EmployeeController {

	/** Inyeccion del servicio de empleados */
	@Autowired
	public IEmployeeService employeeService;

	/**
	 * Peticion para obtener todos los empleados activos de la base de base de datos.
	 *
	 * @return Lista de empleados activos
	 */
	@GetMapping(path = "/all")
	public @ResponseBody List<Employee> getActiveEmployees() { return employeeService.findActive();}

	/**
	 * Peticion que realiza la creacion del usuario a partir de los datos obtenidos.
	 *
	 * @param employee Datos del empleado enviados desde la peticion
	 * @return Dato de si fue el usuario creado o no
	 */
	@PostMapping(path = "/create")
	public @ResponseBody String createEmployes(@RequestBody Employee employee){ return employeeService.create(employee, true);}

	/**
	 * Obtiene los datos del empleado de base de datos a partir del nuip.
	 *
	 * @param nuip numero de documento del empleado obtenido desde la peticion
	 * @return Datos del empleado.
	 */
	@GetMapping(path = "/search/{nuip}")
	public @ResponseBody
	Employee retrieveEmployee(@PathVariable long nuip){ return employeeService.findById(nuip, LocalDate.now());}

	/**
	 * Actualiza los datos del empleado a partir de la informacion obtenida.
	 *
	 * @param employee Datos del empleado enviados desde la peticion
	 * @return Indicacion de si el usuario fue o no creado
	 */
	@PutMapping(path = "/update")
	public @ResponseBody String updateEmployes(@RequestBody Employee employee){ return employeeService.create(employee, false);}

	/**
	 * Actualiza los ceibaCoins del usuario segun la actividad que se halla ejecutado.
	 *
	 * @return Indica a que usuarios les fueron asignados ceibaCoins
	 */
	@PutMapping(path = "/update_coins")
	public @ResponseBody String updateEmployes(){ return employeeService.UpdateCoins(LocalDate.now());}

}
