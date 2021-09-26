package com.bme.adoptationservice.service;


import com.bme.adoptationservice.model.AdoptationDTO;
import com.bme.adoptationservice.model.AdoptationEntity;
import com.bme.adoptationservice.repo.AdoptationRepository;
//import com.bme.petservice.feignclient.PetServiceIF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


public class AdoptationService {
		
		
//		private AdoptationRepository repository;
//		private Date date = new Date(String.valueOf(LocalDateTime.now()));
////		private PetServiceIF petService;
//
//		@PostConstruct
//		public void mock() {
//				AdoptationEntity adoptationEntity = new AdoptationEntity();
//				adoptationEntity.setId(UUID.fromString("3a142008-cffc-437e-bdeb-79a275f43c64"));
//				adoptationEntity.setAdopted(true);
//				adoptationEntity.setAdoptationDate(date);
//				repository.save(adoptationEntity);
//		}
		
//		public Page<AdoptationDTO> findAll(Pageable pageable){
//				return repository.findAll(pageable).map(entity -> {
//						AdoptationDTO dto = new AdoptationDTO();
////						dto.setPets(entity.getPets().stream()
////						.map(petId -> petService.findOnePet(petId).getBody()).collect(Collectors.toList()));
//						return dto;
//				});
//		}
//		public Optional<AdoptationEntity> findById(UUID id){
//				return repository.findById(id);
//		}
//
//		public AdoptationEntity create(AdoptationDTO adoptationDTO){
//				AdoptationEntity entity = new AdoptationEntity();
//
//				return  null;
//		}
		
//		public AdoptationDTO createAdoptation(AdoptationDTO dto){
//
//				AdoptationEntity entity = new AdoptationEntity();
//
//
//				dto.setAdoptationDate(date);
//				entity.setPets(dto.getPets().stream().map(p->
//						UUID.fromString(p.getId()))
//						.collect(Collectors.toList()));
//
//				return null;
//		}
}
