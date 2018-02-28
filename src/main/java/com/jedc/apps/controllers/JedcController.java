package com.jedc.apps.controllers;

import com.jedc.apps.entities.PwrData;
import com.jedc.apps.entities.Users;
import com.jedc.apps.models.PowerData;
import com.jedc.apps.models.UserModel;
import com.jedc.apps.services.PowerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by BRAINERGY SOLUTIONS on 2/28/2018.
 */
@RestController
@RequestMapping("/api/jedc")
public class JedcController {

    @Autowired
    private PowerDataService powerDataService;

    //Save a user
    @PostMapping("/transaction")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity<PwrData> createUser(@Valid @RequestBody PowerData powerData)
    {
        PwrData pData = null;

        if(powerData != null){

            //Assign Variables to the Pwr Data.
            PwrData data = new PwrData();
            data.setAmount(powerData.getAmount());
            data.setVendor(powerData.getVendor());
            data.setDateCreated(powerData.getDateCreated());
            data.setMeterNumber(powerData.getMeterNumber());

            //Save the power data...
            pData = powerDataService.saveData(data);

            //Return param
            return ResponseEntity.ok().body(pData);
        }


        return ResponseEntity.badRequest().body(pData);
    }
}
