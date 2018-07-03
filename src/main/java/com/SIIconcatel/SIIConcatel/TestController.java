package com.SIIconcatel.SIIConcatel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController

@RequestMapping("/api")
public class TestController {

    @Autowired
    private RebelService rebelService;

    @Autowired
    private DTOService dtoService;

    @Autowired
    private ResponseService responseService;

    @RequestMapping (path = "/rebels", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> rebelsRegister(){
        Map<String, Object> rebelsDTO = dtoService.getAllRebelsDTOList(rebelService.findAll());

        return new ResponseEntity<>((rebelsDTO), HttpStatus.OK);
    }

    @RequestMapping(path="/register", method = RequestMethod.POST)
    public ResponseEntity<Boolean> booleanRegister (@RequestParam String name, @RequestParam String planet){
       return responseService.booleanRegister(name, planet);

    }

    @RequestMapping (path = "/fullRegister", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> registerRebel (@RequestParam String name, @RequestParam String planet){
        return responseService.registerRebel(name, planet);

    }

}
