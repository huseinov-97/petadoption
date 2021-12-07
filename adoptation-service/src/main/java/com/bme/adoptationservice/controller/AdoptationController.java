package com.bme.adoptationservice.controller;

import com.bme.adoptationservice.AdoptationMapper;
import com.bme.adoptationservice.dto.AddAdoptationResource;
import com.bme.adoptationservice.dto.AdoptationResource;
import com.bme.adoptationservice.model.AdoptationEntity;
import com.bme.adoptationservice.service.AdoptationService;
import com.bme.petservice.dto.PetResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdoptationController {

    private static final String PATH_ID = "/{id}";
    private static final String PARAM_ID = "id";
    private final AdoptationService service;
    private final AdoptationMapper mapper;

    @GetMapping(PATH_ID)
    public ResponseEntity<AdoptationResource> get(@PathVariable Integer id) {
        return service
                .get(id)
                .map(entity -> ResponseEntity.ok(mapper.to(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AdoptationResource create(@RequestBody @Validated AddAdoptationResource addAdoptationResource) {
        return service.create(addAdoptationResource);
    }

    @PutMapping(PATH_ID)
    public AdoptationResource update(@RequestBody @Validated AddAdoptationResource addAdoptationResource, @PathVariable(PARAM_ID) Integer id) {
        return service.update(addAdoptationResource, id);
    }

    @DeleteMapping(PATH_ID)
    public void delete(@PathVariable(PARAM_ID) Integer id) {
        service.delete(id);
    }

}
