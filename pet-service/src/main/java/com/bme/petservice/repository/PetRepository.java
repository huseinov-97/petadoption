package com.bme.petservice.repository;


import com.bme.petservice.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PetRepository extends JpaRepository<Pet, UUID> {
}
