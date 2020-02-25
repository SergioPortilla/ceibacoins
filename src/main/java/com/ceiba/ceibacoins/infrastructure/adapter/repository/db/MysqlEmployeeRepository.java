package com.ceiba.ceibacoins.infrastructure.adapter.repository.db;

import com.ceiba.ceibacoins.domain.model.Employee;
import com.ceiba.ceibacoins.domain.model.ecxeption.NotFountEmployeeException;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaEmployee;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jparepository.JpaEmployeeRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MysqlEmployeeRepository implements EmployeeRepository {

    public static final String NOT_FOUND_EMPLOYEE = "Empleado no encontrado";

    private JpaEmployeeRepository jpaEmployeeRepository;

    @Autowired
    public MysqlEmployeeRepository (JpaEmployeeRepository jpaEmployeeRepository){
        this.jpaEmployeeRepository = jpaEmployeeRepository ;
    }

    @Override
    public void save(Employee employee) {
        JpaEmployee jpaEmployee = EmployeeMapper.MAPPER.toJpaEmployee(employee);
        jpaEmployeeRepository.save(jpaEmployee);
    }

    @Override
    public Employee findById(Long nuip) {
        return EmployeeMapper.MAPPER.toEmployee( jpaEmployeeRepository.findById(nuip).orElseThrow(() -> new NotFountEmployeeException(NOT_FOUND_EMPLOYEE)));
    }

    @Override
    public List<Employee> findByStateEmployees(Boolean state) {
        return EmployeeMapper.MAPPER.toEmployees(jpaEmployeeRepository.findByStateEmployees(state));
    }
}
