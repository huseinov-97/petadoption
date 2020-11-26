package com.bme.petservice.controller;


import com.bme.petservice.dto.PetDto;
import com.bme.petservice.dto.PetRegistrationDTO;
import com.bme.petservice.model.Pet;
import com.bme.petservice.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;


@RestController
@RequestMapping("/investor")
@AllArgsConstructor
public class PetController {
		
		private PetService service;
		private PetMapper mapper;
		
		@GetMapping
		public ResponseEntity<Page<PetDto>> findAllPets(Pageable pageable) {
				return ResponseEntity.ok(service.findAll(pageable).map(mapper::petToPublicDTO));
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<PetDto> findOnePet(@PathVariable UUID id) {
				return service
						.findOne(id)
						.map(entity -> ResponseEntity.ok(mapper.petToPublicDTO(entity)))
						.orElseGet(() -> ResponseEntity.notFound().build());
		}
		
		@PostMapping
		public ResponseEntity<PetDto> createInvestor(@RequestBody PetRegistrationDTO pet, UriComponentsBuilder b) {
				
						Pet result = service.create(pet);
						
						UriComponents uriComponents = b.path("/pet/{id}").buildAndExpand(result.getId());
						return ResponseEntity.created(uriComponents.toUri()).body(mapper.petToPublicDTO(result));
				
		}
		@DeleteMapping("/{id}")
		public ResponseEntity deletePet(@PathVariable UUID id){
				
				service.deleteById(id);
				
				return new ResponseEntity<>(id, HttpStatus.OK);
		}
}
