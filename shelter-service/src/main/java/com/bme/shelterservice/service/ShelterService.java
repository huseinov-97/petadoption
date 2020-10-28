package com.bme.shelterservice.service;


import com.bme.shelterservice.dto.Shelter;

import java.util.List;


public interface ShelterService {
		
		
		List<Shelter> getAllShelters();
		
		Shelter getShelter(int id);
}
