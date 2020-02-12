package com.ceiba.ceibacoins.domain.ports;

import com.ceiba.ceibacoins.infrastructure.adapter.repository.db.dto.ActivityDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Crud de las actividades.
 *
 * @since 07/02/2020
 * @author sergio.portilla
 */
public interface IActivityRepository extends CrudRepository<ActivityDTO, Long>{

}
