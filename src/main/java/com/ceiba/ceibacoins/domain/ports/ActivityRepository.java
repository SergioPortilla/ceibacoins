package com.ceiba.ceibacoins.domain.ports;

import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.domain.model.Employee;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository {

    Activity findById(Long idActivity);

    List<Activity> findAll();
}
