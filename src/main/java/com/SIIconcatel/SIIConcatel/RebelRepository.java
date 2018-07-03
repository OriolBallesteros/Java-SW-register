package com.SIIconcatel.SIIConcatel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RebelRepository extends JpaRepository<Rebel, Long>{
    Rebel findByName(String name);

}
