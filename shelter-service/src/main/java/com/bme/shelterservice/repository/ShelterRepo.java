package com.bme.shelterservice.repository;


import com.bme.shelterservice.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ShelterRepo extends JpaRepository<Shelter, Integer> {

}
