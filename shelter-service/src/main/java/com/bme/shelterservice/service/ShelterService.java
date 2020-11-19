package com.bme.shelterservice.service;


import com.bme.shelterservice.exception.ResourceNotFoundException;
import com.bme.shelterservice.model.Shelter;
import com.bme.shelterservice.repository.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ShortLookupTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ShelterService {
		
		@Autowired
		ShelterRepo shelterRepo;
		
		public Shelter createOrUpdateShelter(Shelter entity) throws ResourceNotFoundException{
				Optional<Shelter> shelter = shelterRepo.findById(entity.getId());
				
				if(shelter.isPresent()){
						Shelter newShelter = shelter.get();
						newShelter.setEmail(entity.getEmail());
						newShelter.setAddress(entity.getAddress());
						newShelter.setDescription(entity.getDescription());
						newShelter.setPhoneNumber(entity.getPhoneNumber());
						newShelter.setLastName(entity.getLastName());
						newShelter.setPostalCode(entity.getPostalCode());
						newShelter.setOwnerName(entity.getOwnerName());
						newShelter.setMaxSize(entity.getMaxSize());
						newShelter.setShelterName(entity.getShelterName());
						
						newShelter = shelterRepo.save(newShelter);
						
						return newShelter;
				}
				else{
						entity = shelterRepo.save(entity);
						
						return entity;
				}
		}
		public void deleteShelterById(Integer id) throws ResourceNotFoundException
		{
				Optional<Shelter> employee = shelterRepo.findById(id);
				
				if(employee.isPresent())
				{
						shelterRepo.deleteById(id);
				} else {
						throw new ResourceNotFoundException("No employee record exist for given id");
				}
		}
		
		public List<Shelter> getAllShelters() {
				
				List<Shelter> shelters = new ArrayList<Shelter>();
				shelterRepo.findAll().forEach(shelter -> shelters.add(shelter));
				return shelters;
				
		}
		public Shelter getShelter(int id){
				return shelterRepo.findById(id).get();
		}
}
