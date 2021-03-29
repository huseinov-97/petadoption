package com.bme.adoptationservice.repo;


import com.bme.adoptationservice.model.AdoptationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AdoptationRepository extends JpaRepository<AdoptationEntity, UUID> {

}
