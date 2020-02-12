package com.ceiba.ceibacoins.domain.ports;

import java.util.List;

import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Crud de Empleados.
 *
 * @since 06/02/2020
 * @author sergio.portilla
 */
public interface IEmployeeRepository extends CrudRepository<EmployeeDTO,Long> {

	/**
	 * Obtiene todos los empleados en un estado especifico de base de datos.
	 *
	 * @param state Estado de los empleados
	 * @return Lista de empleados segun el estado seleccionado
	 */
	@Query("SELECT e FROM EmployeeDTO e WHERE e.state = :state")
	List<EmployeeDTO> findByStateEmployees(@Param("state") Boolean state);
}
