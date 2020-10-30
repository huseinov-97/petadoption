package com.bme.shelterservice.service;


import com.bme.shelterservice.dto.Shelter;
import com.bme.shelterservice.repository.ShelterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelterService {
		
		@Autowired
		ShelterRepo shelterRepo;
		public List<Shelter> getAllShelters() {
				
				List<Shelter> shelters = new ArrayList<Shelter>();
				shelterRepo.findAll().forEach(shelter -> shelters.add(shelter));
				return shelters;
				
		}
		public Shelter getShelter(int id){
				return shelterRepo.findById(id).get();
		}
}
