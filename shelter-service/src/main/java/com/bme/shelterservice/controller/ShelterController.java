package com.bme.shelterservice.controller;


import com.bme.shelterservice.exception.ResourceNotFoundException;
import com.bme.shelterservice.model.Shelter;
import com.bme.shelterservice.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShelterController {
		
		@Autowired
		ShelterService shelterService;
		
		@PostMapping("shelter/")
		
		@GetMapping(value = "/shelters",
					produces = {MediaType.APPLICATION_JSON_VALUE,
								MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<List<Shelter>> getAllShelters(){
				
				List<Shelter> list = shelterService.getAllShelters();
				return new ResponseEntity<List<Shelter>>(list, new HttpHeaders(), HttpStatus.OK);
		}
		
		@GetMapping(value = "/shelters/{id}",
					produces = {MediaType.APPLICATION_JSON_VALUE,
								MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<Shelter> getShelter(@PathVariable("id") int id) throws ResourceNotFoundException {
				Shelter shelter = shelterService.getShelter(id);
				return new ResponseEntity<Shelter>(shelter,new HttpHeaders(), HttpStatus.OK);
		}
		
		@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
								 MediaType.APPLICATION_XML_VALUE},
					 produces = {MediaType.APPLICATION_JSON_VALUE,
							     MediaType.APPLICATION_XML_VALUE})
		public ResponseEntity<Shelter> createOrUpdateShelter(Shelter shelter) throws ResourceNotFoundException{
				Shelter entity = shelterService.createOrUpdateShelter(shelter);
				return new ResponseEntity<Shelter>(entity, new HttpHeaders(), HttpStatus.OK);
		}
		
		@DeleteMapping(value = "shelters/delete/{id}",
				       consumes = {MediaType.APPLICATION_JSON_VALUE,
							       MediaType.APPLICATION_XML_VALUE})
		public HttpStatus deleteShelter(@PathVariable("id") Integer id)
				throws ResourceNotFoundException {
				shelterService.deleteShelterById(id);
				return HttpStatus.FORBIDDEN;
		}
		
}
