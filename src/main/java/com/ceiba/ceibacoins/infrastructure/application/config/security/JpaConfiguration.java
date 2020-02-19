package com.ceiba.ceibacoins.infrastructure.application.config.security;

import com.ceiba.ceibacoins.domain.ports.ActivityRepository;
import com.ceiba.ceibacoins.domain.ports.EmployeeRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.MysqlActivityRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.MysqlEmployeeRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jparepository.JpaActivityRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jparepository.JpaEmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfiguration {

    @Bean
    public EmployeeRepository employeeRepository(JpaEmployeeRepository jpaEmployeeRepository) {
        return new MysqlEmployeeRepository(jpaEmployeeRepository);
    }

    @Bean
    public ActivityRepository activityRepository(JpaActivityRepository jpaActivityRepository) {
        return new MysqlActivityRepository(jpaActivityRepository);
    }

}