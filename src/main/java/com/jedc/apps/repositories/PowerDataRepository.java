package com.jedc.apps.repositories;

import com.jedc.apps.entities.PwrData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by BRAINERGY SOLUTIONS on 2/28/2018.
 */
@Repository
public interface PowerDataRepository extends CrudRepository<PwrData, Integer>{
}
