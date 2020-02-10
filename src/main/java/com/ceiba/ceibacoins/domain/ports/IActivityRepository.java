package com.ceiba.ceibacoins.domain.ports;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.ceibacoins.domain.model.Activity;

public interface IActivityRepository extends CrudRepository<Activity, Long>{

}
