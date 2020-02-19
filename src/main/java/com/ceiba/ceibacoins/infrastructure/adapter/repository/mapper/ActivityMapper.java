package com.ceiba.ceibacoins.infrastructure.adapter.repository.mapper;

import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaActivity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActivityMapper {

    ActivityMapper MAPPER = Mappers.getMapper(ActivityMapper.class);

    Activity toActivity(JpaActivity jpaActivity);

    JpaActivity toJpaActivity(Activity activity);

    List<Activity> toActivities(List<JpaActivity> jpaActivities);
}
