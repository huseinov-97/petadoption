package com.bme.shelterservice.service;


//import com.bme.petservice.feignclient.PetServiceIF;
//import com.bme.petservice.feignclient.PetServiceIF;
import com.bme.shelterservice.dto.ShelterPrivateDTO;
import com.bme.shelterservice.exception.ResourceNotFoundException;
import com.bme.shelterservice.model.Shelter;
import com.bme.shelterservice.repository.ShelterRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class ShelterService {
		
//		private ShelterRepo shelterRepo;
//		private PetServiceIF petService;
//
//		@PostConstruct
//		public void mockData() {
//				Shelter entity = new Shelter();
//				entity.setShelterName("My mock shelter");
//				entity.setPets(Collections.singletonList(UUID.fromString("3a142008-cffc-437e-bdeb-79a275f43c64")));
//				shelterRepo.save(entity);
//		}
//
//		/**
//		 * Reads all shelters and their associations. This will call to the pet service to retrieve the data.
//		 * @param pageable
//		 * @return
//		 */
//		public Page<ShelterPrivateDTO> readAll(Pageable pageable) {
//				return shelterRepo.findAll(pageable).map(entity -> {
//						ShelterPrivateDTO dto = new ShelterPrivateDTO();
//						dto.setShelterName(entity.getShelterName());
//						dto.setPets(entity.getPets().stream()
//								.map(petId -> petService.findOnePet(petId).getBody())
//								.collect(Collectors.toList()));
//						return dto;
//				});
//		}
//
//		public Shelter createOrUpdateShelter(Shelter entity) throws ResourceNotFoundException{
//				Optional<Shelter> shelter = shelterRepo.findById(entity.getId());
//
//				if(shelter.isPresent()){
//						Shelter newShelter = shelter.get();
//						newShelter.setEmail(entity.getEmail());
//						newShelter.setAddress(entity.getAddress());
//						newShelter.setDescription(entity.getDescription());
//						newShelter.setPhoneNumber(entity.getPhoneNumber());
//						newShelter.setPostalCode(entity.getPostalCode());
//						newShelter.setOwnerName(entity.getOwnerName());
//						newShelter.setMaxSize(entity.getMaxSize());
//						newShelter.setShelterName(entity.getShelterName());
//
//						newShelter = shelterRepo.save(newShelter);
//
//						return newShelter;
//				}
//				else{
//						entity = shelterRepo.save(entity);
//
//						return entity;
//				}
//		}
//		public void deleteShelterById(UUID id) throws ResourceNotFoundException
//		{
//				Optional<Shelter> employee = shelterRepo.findById(id);
//
//				if(employee.isPresent())
//				{
//						shelterRepo.deleteById(id);
//				} else {
//						throw new ResourceNotFoundException("No employee record exist for given id");
//				}
//		}
//
//		public Shelter getShelter(UUID id){
//				return shelterRepo.findById(id).get();
//		}
}
