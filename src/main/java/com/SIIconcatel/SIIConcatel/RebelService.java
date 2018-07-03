package com.SIIconcatel.SIIConcatel;

import java.util.List;

public interface RebelService {
    List<Rebel> findAll();
    Rebel save (Rebel rebel);
    Rebel findByName(String name);
}
