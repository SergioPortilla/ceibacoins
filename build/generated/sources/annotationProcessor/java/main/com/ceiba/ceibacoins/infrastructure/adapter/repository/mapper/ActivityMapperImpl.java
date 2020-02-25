package com.ceiba.ceibacoins.infrastructure.adapter.repository.mapper;

import com.ceiba.ceibacoins.domain.model.Activity;
import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaActivity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-25T15:35:52-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
@Component
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public Activity toActivity(JpaActivity jpaActivity) {
        if ( jpaActivity == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setIdActivity( jpaActivity.getIdActivity() );
        activity.setName( jpaActivity.getName() );
        activity.setPrice( jpaActivity.getPrice() );

        return activity;
    }

    @Override
    public JpaActivity toJpaActivity(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        JpaActivity jpaActivity = new JpaActivity();

        jpaActivity.setIdActivity( activity.getIdActivity() );
        jpaActivity.setName( activity.getName() );
        jpaActivity.setPrice( activity.getPrice() );

        return jpaActivity;
    }

    @Override
    public List<Activity> toActivities(List<JpaActivity> jpaActivities) {
        if ( jpaActivities == null ) {
            return null;
        }

        List<Activity> list = new ArrayList<Activity>( jpaActivities.size() );
        for ( JpaActivity jpaActivity : jpaActivities ) {
            list.add( toActivity( jpaActivity ) );
        }

        return list;
    }
}
