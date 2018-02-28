package com.jedc.apps.services.implementation;

import com.jedc.apps.entities.PwrData;
import com.jedc.apps.repositories.PowerDataRepository;
import com.jedc.apps.services.PowerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by BRAINERGY SOLUTIONS on 2/28/2018.
 */
@Service
public class PowerDataServiceImplementation implements PowerDataService {

    @Autowired
    PowerDataRepository powerDataRepository;

    public PwrData saveData(PwrData pwrData){
        return powerDataRepository.save(pwrData);
    }
}
