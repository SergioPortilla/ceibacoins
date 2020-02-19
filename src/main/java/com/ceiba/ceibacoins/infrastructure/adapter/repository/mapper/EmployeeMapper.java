package com.ceiba.ceibacoins.infrastructure.adapter.repository.mapper;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(JpaEmployee jpaEmployee);

    JpaEmployee toJpaEmployee(Employee employee);

    List<Employee> toEmployees(List<JpaEmployee> jpaEmployees);
}
