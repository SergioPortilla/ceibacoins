package com.ceiba.ceibacoins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.ceiba.ceibacoins")
@EnableJpaRepositories(basePackages = "com.ceiba.ceibacoins")
@ComponentScan(value = {"com.ceiba.ceibacoins"})
@EnableAutoConfiguration
public class CeibacoinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeibacoinsApplication.class, args);
	}

}
