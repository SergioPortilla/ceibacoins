package com.ceiba.ceibacoins.application.caseuse;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.ceibacoins.domain.model.Employee;

/**
 * Servicio de empleados.
 *
 * @since 06/02/2020
 * @author sergio.portilla
 */
public interface IEmployeeService {

	/**
	 * Busca todos los empleados activos de Ceiba.
	 *
	 * @return lista de empleados activos
	 */
	public List<Employee> findActive();

	/**
	 * Busca un empleado segun su nuip
	 *
	 * @param nuip numero de identificacion del empleado
	 * @return Datos del empleado buscado.
	 */
	public Employee findById(Long nuip);

	/**
	 * Busca empleados segun su id verificando la fecha en la cual se consulta si es entre semana.
	 *
	 * @param nuip numero de identificacion del empleado
	 * @param date fecha en la cual se realizo la busqueda del empleado.
	 * @return si es fin de semana devuelve nulo, de lo contrario, el usuario buscado
	 */
	public Employee findById(Long nuip, LocalDate date);

	/**
	 * Realiza la creacion y modificacion del empleado.
	 * @param employee datos del Empleado
	 * @param newEmployee si es nuevo sera verdadero, de lo contrario falso
	 * @return informacion de si se creo o edito el usuario
	 */
	public String create(Employee employee, Boolean newEmployee);

	/**
	 * Verifica si todos los empleados creados se les debe agregar CeibaCoins segun la fecha.
	 *
	 * @param date fecha en la cual se realiza la verificacion
	 * @return indica a que empleados le fueron asignados ceibacoins
	 */
	public String UpdateCoins(LocalDate date);

}
