package com.ceiba.ceibacoins.infrastructure.adapter.repository.mapper;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-19T16:26:45-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEmployee(JpaEmployee jpaEmployee) {
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
    public JpaEmployee toJpaEmployee(Employee employee) {
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
    public List<Employee> toEmployees(List<JpaEmployee> jpaEmployees) {
        if ( jpaEmployees == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( jpaEmployees.size() );
        for ( JpaEmployee jpaEmployee : jpaEmployees ) {
            list.add( toEmployee( jpaEmployee ) );
        }

        return list;
    }
}
