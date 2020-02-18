package com.ceiba.ceibacoins.infrastructure.adapter.repository.db.mapper;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.jpaentity.JpaEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-18T14:38:02-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee employeeDTO(JpaEmployee jpaEmployee) {
        if ( jpaEmployee == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setNuip( jpaEmployee.getNuip() );
        employee.setEmployeeName( jpaEmployee.getEmployeeName() );
        employee.setEmployeeLastName( jpaEmployee.getEmployeeLastName() );
        employee.setBirthday( jpaEmployee.getBirthday() );
        employee.setEntry( jpaEmployee.getEntry() );
        employee.setCeibaCoins( jpaEmployee.getCeibaCoins() );
        employee.setState( jpaEmployee.getState() );

        return employee;
    }

    @Override
    public JpaEmployee employee(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        JpaEmployee jpaEmployee = new JpaEmployee();

        jpaEmployee.setNuip( employee.getNuip() );
        jpaEmployee.setEmployeeName( employee.getEmployeeName() );
        jpaEmployee.setEmployeeLastName( employee.getEmployeeLastName() );
        jpaEmployee.setBirthday( employee.getBirthday() );
        jpaEmployee.setEntry( employee.getEntry() );
        jpaEmployee.setCeibaCoins( employee.getCeibaCoins() );
        jpaEmployee.setState( employee.getState() );

        return jpaEmployee;
    }

    @Override
    public List<Employee> toEmployees(List<JpaEmployee> employeesDTO) {
        if ( employeesDTO == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( employeesDTO.size() );
        for ( JpaEmployee jpaEmployee : employeesDTO ) {
            list.add( employeeDTO( jpaEmployee ) );
        }

        return list;
    }
}
