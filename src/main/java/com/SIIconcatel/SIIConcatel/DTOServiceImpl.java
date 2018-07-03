package com.SIIconcatel.SIIConcatel;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service
public class DTOServiceImpl implements DTOService {

    @Override
    public Map<String, Object> getAllRebelsDTOList(List<Rebel> rebels){
        Map<String, Object> dto = new LinkedHashMap<>();
            dto.put("rebels", rebels.stream()
                                    .map(rebel -> rebelDTO(rebel))
                                    .collect(toList()));
        return dto;
    }


    public Map<String, Object> rebelDTO(Rebel rebel){
        Map<String, Object> dto = new LinkedHashMap<>();

        dto.put("name", rebel.getName());
        dto.put("planet", rebel.getPlanetOrigin());
        dto.put("date_register", rebel.getDateTimeRegister().toString());

        return dto;
        }
}

