package com.bme.shelterservice.repository;


import com.bme.shelterservice.dto.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShelterRepo extends JpaRepository<Shelter, Long> {
		
}
