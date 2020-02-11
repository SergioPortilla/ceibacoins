package com.ceiba.ceibacoins.domain.ports;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.ceibacoins.domain.model.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee,Long> {

	/**
	 *
	 * @param state
	 * @return
	 */
	@Query("SELECT e FROM Employee e WHERE e.state = :state")
	List<Employee> findByStateEmployees(@Param("state") Boolean state);
}
