package com.ceiba.ceibacoins.application.caseuse;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.model.validation.ValidationDateEmployee;
import com.ceiba.ceibacoins.domain.ports.ActivityRepository;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateEmployee {

    private static final String CREADO = "Creado Exitosamente";
    private static final String ACTUALIZADO = "Usuario Actualizado Exitosamente";
    private static final String EXISTE = "El usuario ya existe";
    private static final String NOEXISTE = "El usuario no existe";
    private static final String CEIBACOINSASIGNADOS = "Se agregaron CeibaCoins a: ";
    private static final String ERROR = "Error obtenido: ";

    /** Inyeccion del repositorio de empleados */
    private final EmployeeRepository employeeRepository;

    /** Inyeccion del repositorio de actividades */
    private ActivityRepository activityRepository;

    private final FindEmployee findEmployee;

    public UpdateEmployee(EmployeeRepository employeeRepository, ActivityRepository activityRepository, FindEmployee findEmployee) {
        this.employeeRepository = employeeRepository;
        this.activityRepository = activityRepository;
        this.findEmployee = findEmployee;
    }

    public String createEmployee(Employee employee, boolean newEmployee) {
        try {
            if (newEmployee ^ (findEmployee.findEmployeeById(employee.getNuip()) != null)){
                employeeRepository.save(employee);
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
        for (Employee employee : findEmployee.findActiveEmployees()) {
            boolean modify;
            if (modify = ValidationDateEmployee.isBirthDay(date, employee.getBirthday()))
                employee.setCeibaCoins(employee.getCeibaCoins() + activityRepository.findById(1L).getPrice());
            if (modify = modify || ValidationDateEmployee.isEntry(date, employee.getEntry()))
                employee.setCeibaCoins(employee.getCeibaCoins() + activityRepository.findById(2L).getPrice());
            if (!modify)
                continue;
            createEmployee(employee, false);
            usersModify.add(employee.getEmployeeName());
        }
        return CEIBACOINSASIGNADOS+usersModify.toString();
    }
}
