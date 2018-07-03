package com.SIIconcatel.SIIConcatel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseServiceImpl implements ResponseService{
    @Autowired
    RebelService rebelService;

    @Override
    public ResponseEntity<Boolean> booleanRegister (String name, String planet){

        ResponseEntity<Map<String, Object>> fullRegRspnsEnt = changeRpnsEnt(name, planet);

        HttpStatus statusReceived = fullRegRspnsEnt.getStatusCode();

        if (statusReceived != HttpStatus.CREATED) {
            return new ResponseEntity<Boolean>(false, statusReceived);
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<Map<String, Object>> registerRebel (String name, String planet){

        return changeRpnsEnt(name, planet);
    }

    @Override
    public ResponseEntity<Map<String, Object>> changeRpnsEnt (String name, String planet){
        if (name.isEmpty() || planet.isEmpty()) {
            return new ResponseEntity<>(makeMap("error", "Enter some info"), HttpStatus.FORBIDDEN);
        }

        Rebel rebel = rebelService.findByName(name);
        if (rebel != null) {
            return new ResponseEntity<>(makeMap("error", "Rebel already registered"),
                    HttpStatus.FORBIDDEN);
        }

        Rebel newRebel = rebelService.save(new Rebel(name, planet));
        String successRegister = "Rebel "+ newRebel.getName()
                +" on "+newRebel.getPlanetOrigin()
                +" at "+newRebel.getDateTimeRegister();

        return new ResponseEntity<>(makeMap("success", successRegister), HttpStatus.CREATED);

    }


    private Map<String, Object> makeMap(String key, Object value){
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

}
