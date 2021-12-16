package com.bme.petservice.controller;


import com.bme.petservice.dto.AddPetResource;
import com.bme.petservice.dto.PetResource;
import com.bme.petservice.feignclient.PetServiceIF;
import com.bme.petservice.mapper.PetMapper;
import com.bme.petservice.model.Pet;
import com.bme.petservice.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class PetController implements PetServiceIF {

    private static final String PATH_ID = "/{id}";
    private final PetService service;
    private final PetMapper mapper;

    @GetMapping
    public ResponseEntity<List<PetResource>> list() {
        return ResponseEntity.ok(service.list().stream().map(PetResource::toPetResource).collect(Collectors.toList()));
    }

    @GetMapping(PATH_ID)
    public ResponseEntity<PetResource> get(@PathVariable Integer id) {
        return service
                .get(id)
                .map(entity -> ResponseEntity.ok(mapper.to(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PetResource> create(@RequestBody AddPetResource pet, UriComponentsBuilder b) {
        Pet result = service.create(pet);

        UriComponents uriComponents = b.path("/pet/{id}").buildAndExpand(result.getId());
        return ResponseEntity.created(uriComponents.toUri()).body(mapper.to(result));
    }

    @DeleteMapping(PATH_ID)
    public ResponseEntity deletePet(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
