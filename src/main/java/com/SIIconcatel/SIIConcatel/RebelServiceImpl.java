package com.SIIconcatel.SIIConcatel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebelServiceImpl implements RebelService{
    @Autowired
    RebelRepository rebelrepo;

    @Override
    public Rebel save(Rebel rebel){
        return rebelrepo.save(rebel);
    }

    @Override
    public Rebel findByName(String name){
        return rebelrepo.findByName(name);
    }

    @Override
    public List<Rebel> findAll(){
        return rebelrepo.findAll();
    }
}
