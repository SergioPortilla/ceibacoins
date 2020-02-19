package com.ceiba.ceibacoins.infrastructure.adapter.repository.jparepository;

import com.ceiba.ceibacoins.infrastructure.adapter.repository.jpaentity.JpaActivity;
import org.springframework.data.repository.CrudRepository;

/**
 * Crud de las actividades.
 *
 * @since 07/02/2020
 * @author sergio.portilla
 */
public interface JpaActivityRepository extends CrudRepository<JpaActivity, Long>{

}
