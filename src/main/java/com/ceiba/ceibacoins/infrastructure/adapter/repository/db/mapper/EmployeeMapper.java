package com.ceiba.ceibacoins.infrastructure.adapter.repository.db.mapper;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee employeeDTO(EmployeeDTO employeeDTO);

    EmployeeDTO employee(Employee employee);

    List<Employee> toEmployees(List<EmployeeDTO> employeesDTO);
}
