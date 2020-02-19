package com.ceiba.ceibacoins.infrastructure.adapter.repository.db;

import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.domain.ports.ActivityRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaActivity;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jparepository.JpaActivityRepository;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MysqlActivityRepository implements ActivityRepository {

    private JpaActivityRepository jpaActivityRepository;

    @Autowired
    public MysqlActivityRepository (JpaActivityRepository jpaActivityRepository){
        this.jpaActivityRepository = jpaActivityRepository ;
    }

    @Override
    public Activity findById(Long idActivity) {
        return ActivityMapper.MAPPER.toActivity(jpaActivityRepository.findById(idActivity).orElse(new JpaActivity()));
    }

    @Override
    public List<Activity> findAll() {
        return ActivityMapper.MAPPER.toActivities((List<JpaActivity>) jpaActivityRepository.findAll());
    }
}
