package com.SIIconcatel.SIIConcatel;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ResponseService {
    ResponseEntity<Boolean> booleanRegister(String name, String planet);
    ResponseEntity<Map<String, Object>> registerRebel(String name, String planet);
    ResponseEntity<Map<String, Object>> changeRpnsEnt(String name, String planet);

}
