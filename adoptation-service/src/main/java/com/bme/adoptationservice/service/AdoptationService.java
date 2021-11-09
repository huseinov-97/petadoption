package com.bme.adoptationservice.service;


import com.bme.adoptationservice.dto.AdoptationResource;
import com.bme.adoptationservice.model.AdoptationEntity;
import com.bme.adoptationservice.repo.AdoptationRepository;
import com.bme.petservice.feignclient.PetServiceIF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


public class AdoptationService {
		
		
		private AdoptationRepository repository;
		private PetServiceIF petService;
		
		@PostConstruct
		public void mock() {
				AdoptationEntity adoptationEntity = new AdoptationEntity();
				adoptationEntity.setAdopted(true);
				adoptationEntity.setAdoptationDate(Instant.now());
				repository.save(adoptationEntity);
		}
		
		public Page<AdoptationResource> findAll(Pageable pageable){
				return repository.findAll(pageable).map(entity -> {
						AdoptationResource dto = new AdoptationResource();
						dto.setPets(entity.getPets().stream()
						.map(petId -> petService.get(petId).getBody()).collect(Collectors.toList()));
						return dto;
				});
		}
		public Optional<AdoptationEntity> findById(Integer id){
				return repository.findById(id);
		}
		
		public AdoptationEntity create(AdoptationResource adoptationDTO){
				AdoptationEntity entity = new AdoptationEntity();
				
				return  null;
		}
		
		public AdoptationResource createAdoptation(AdoptationResource dto){
				
				AdoptationEntity entity = new AdoptationEntity();
				
//
//				dto.setAdoptationDate(date);
//				entity.setPets(dto.getPets().stream().map(p->
//						UUID.fromString(p.getId()))
//						.collect(Collectors.toList()));
				
				return null;
		}
}
