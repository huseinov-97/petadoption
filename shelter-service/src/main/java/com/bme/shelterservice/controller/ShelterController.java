package com.bme.shelterservice.controller;


import com.bme.shelterservice.dto.Shelter;
import com.bme.shelterservice.service.ShelterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public class ShelterController {

		private ShelterService shelterService;
		
		@GetMapping("shelters")
		public List<Shelter> getAllShelters(){
				return shelterService.getAllShelters();
		}
		
		@GetMapping("/shelter/{id}")
		public Shelter getShelter(@PathVariable int id){
				return shelterService.getShelter(id);
		}
		
}
