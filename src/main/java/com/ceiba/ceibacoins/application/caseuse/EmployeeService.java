package com.ceiba.ceibacoins.application.caseuse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.ports.ActivityRepository;
import com.ceiba.ceibacoins.domain.model.validation.ValidationDateEmployee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto.ActivityDTO;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;

@Service
public class EmployeeService {

	private static final String CREADO = "Creado Exitosamente";
	private static final String ACTUALIZADO = "Usuario Actualizado Exitosamente";
	private static final String EXISTE = "El usuario ya existe";
	private static final String NOEXISTE = "El usuario no existe";
	private static final String CEIBACOINSASIGNADOS = "Se agregaron CeibaCoins a: ";
	private static final String ERROR = "Error obtenido: ";

	/** Inyeccion del repositorio de empleados */
	@Autowired
	private EmployeeRepository employeeRepository;

	/** Inyeccion del repositorio de actividades */
	@Autowired
	private ActivityRepository activityRepository;

	public String create(Employee employee, boolean newEmployee) {
		try {
			if (newEmployee ^ (findById(employee.getNuip()) != null)){
				employeeRepository.save(EmployeeMapper.MAPPER.employee(employee));
				return newEmployee ? CREADO : ACTUALIZADO;
			} else {
				return newEmployee ? EXISTE : NOEXISTE;
			}
		} catch (Exception e) {
			return ERROR+e.getMessage();
		}
	}

	public String updateCoins(LocalDate date) {
		List<String> usersModify = new ArrayList<>();
		for (Employee employee : findActive()) {
			boolean modify = false;
			if (modify = ValidationDateEmployee.isBirthDay(date, employee.getBirthday()))
				employee.setCeibaCoins(employee.getCeibaCoins() + activityRepository.findById(1L).orElse(new ActivityDTO()).getPrice());
			if (modify = modify || ValidationDateEmployee.isEntry(date, employee.getEntry()))
				employee.setCeibaCoins(employee.getCeibaCoins() + activityRepository.findById(2L).orElse(new ActivityDTO()).getPrice());
			if (!modify)
				continue;
			create(employee, false);
			usersModify.add(employee.getEmployeeName());
		}
		return CEIBACOINSASIGNADOS+usersModify.toString();
	}

	public List<Employee> findActive() {
		return EmployeeMapper.MAPPER.toEmployees(employeeRepository.findByStateEmployees(true));
	}

	public Employee findById(Long nuip) {
		return EmployeeMapper.MAPPER.employeeDTO(employeeRepository.findById(nuip).orElse(null));
	}

	public Employee findById(Long nuip, LocalDate date) {
		if(ValidationDateEmployee.isWeekDay(date)) return findById(nuip); else return null;
	}

}
