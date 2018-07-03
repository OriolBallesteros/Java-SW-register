package com.SIIconcatel.SIIConcatel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rebel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String planetOrigin;
    private Date dateTimeRegister;

    public Rebel(){ }

    public Rebel (String name, String planet){
        this.name = name;
        this.planetOrigin = planet;
        this.dateTimeRegister = new Date();

    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getPlanetOrigin(){
        return this.planetOrigin;
    }

    public void setPlanetOrigin(String newPlanet){
        this.planetOrigin = newPlanet;
    }

    public Date getDateTimeRegister(){
        return this.dateTimeRegister;
    }
}
