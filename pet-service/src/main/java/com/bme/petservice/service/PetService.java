package com.bme.petservice.service;


import com.bme.petservice.dto.PetRegistrationDTO;
import com.bme.petservice.model.Pet;
import com.bme.petservice.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
@Slf4j
public class PetService {
		
		private PetRepository repository;
		
		@PostConstruct
		public void mock() {
				Pet petEntity = new Pet();
				petEntity.setName("Pet 1");
				petEntity.setId(UUID.fromString("3a142008-cffc-437e-bdeb-79a275f43c64"));
				petEntity.setAge(2);
				petEntity.setGender("Male");
				petEntity.setTypeOfPet("cat");
				repository.save(petEntity);
		}
		
		public Page<Pet> findAll(Pageable pageable) {
				return repository.findAll(pageable);
		}
		
		public Optional<Pet> findOne(UUID id) {
				return repository.findById(id);
		}
		
		public Pet create(PetRegistrationDTO dto) {
				log.debug("Creating new Pet sample {}", dto);
				
				Pet entity = new Pet();
				entity.setName(dto.getName());
				entity.setTypeOfPet(dto.getType());
				entity.setGender(dto.getGender());
				entity.setAge(dto.getAge());
				return repository.save(entity);
		}
		
		public void deleteById(UUID id){
				repository.deleteById(id);
		}
		
		
		
}
