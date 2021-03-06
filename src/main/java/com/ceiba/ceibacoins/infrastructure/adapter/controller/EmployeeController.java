package com.ceiba.ceibacoins.infrastructure.adapter.controller;

import com.ceiba.ceibacoins.application.caseuse.FindEmployee;
import com.ceiba.ceibacoins.application.caseuse.UpdateEmployee;
import com.ceiba.ceibacoins.domain.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

/**
 * Controller que obtiene todas las peticiones realizadas al aplicativo.
 *
 * @since 08/02/2020
 * @author sergio.portilla
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping(path = "/ceibacoins")
public class EmployeeController {

	/** Inyeccion del servicio de creacion/modificacion de empleados */
	public final UpdateEmployee updateEmployee;
	/** Inyeccion del servicio de busquedas de empleados */
	public final FindEmployee findEmployee;

	public EmployeeController(UpdateEmployee updateEmployee, FindEmployee findEmployee) {
		this.updateEmployee = updateEmployee;
		this.findEmployee = findEmployee;
	}

	/**
	 * Peticion para obtener todos los empleados activos de la base de base de datos.
	 *
	 * @return Lista de empleados activos
	 */
	@GetMapping
	public @ResponseBody List<Employee> getActiveEmployees() { return findEmployee.findActiveEmployees();}

	/**
	 * Peticion que realiza la creacion del usuario a partir de los datos obtenidos.
	 *
	 * @param employee Datos del empleado enviados desde la peticion
	 * @return Dato de si fue el usuario creado o no
	 */
	@PostMapping
	public @ResponseBody String createEmployes(@RequestBody Employee employee){ return updateEmployee.createEmployee(employee, true);}

	/**
	 * Obtiene los datos del empleado de base de datos a partir del nuip.
	 *
	 * @param nuip numero de documento del empleado obtenido desde la peticion
	 * @return Datos del empleado.
	 */
	@GetMapping(path = "/{nuip}")
	public @ResponseBody
	Employee retrieveEmployee(@PathVariable long nuip){ return findEmployee.findEmployeeById(nuip, LocalDate.now());}

	/**
	 * Actualiza los datos del empleado a partir de la informacion obtenida.
	 *
	 * @param employee Datos del empleado enviados desde la peticion
	 * @return Indicacion de si el usuario fue o no creado
	 */
	@PutMapping
	public @ResponseBody String updateEmployes(@RequestBody Employee employee){ return updateEmployee.createEmployee(employee, false);}

	/**
	 * Actualiza los ceibaCoins del usuario segun la actividad que se halla ejecutado.
	 *
	 * @return Indica a que usuarios les fueron asignados ceibaCoins
	 */
	@PatchMapping
	public @ResponseBody String updateEmployes(){ return updateEmployee.updateCoins(LocalDate.now());}

}
