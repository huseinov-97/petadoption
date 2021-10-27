package com.bme.shelterservice.controller;


import com.bme.shelterservice.dto.AddShelterResource;
import com.bme.shelterservice.dto.ShelterResource;
import com.bme.shelterservice.dto.UpdateShelterResource;
import com.bme.shelterservice.feign.ShelterServiceIF;
import com.bme.shelterservice.service.ShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/shelters")
@RequiredArgsConstructor
public class ShelterController implements ShelterServiceIF {

    private static final String PATH_ID = "/{id}";
    private static final String PARAM_ID = "id";
    private final ShelterService service;

    @GetMapping("/list")
    public List<ShelterResource> list() {
        return service.list();
    }

    @GetMapping(PATH_ID)
    public ShelterResource get(@PathVariable(PARAM_ID) Integer id) {
        return service.get(id);
    }

    @PostMapping
    public ShelterResource create(@RequestBody @Validated AddShelterResource addShelterResource) {
        return service.create(addShelterResource);
    }

    @PutMapping(PATH_ID)
    public ShelterResource update(@RequestBody @Validated UpdateShelterResource updateShelterResource, @PathVariable(PARAM_ID) Integer id) {
        return service.update(updateShelterResource, id);
    }

    @DeleteMapping(PATH_ID)
    public void delete(@PathVariable(PARAM_ID) Integer id) {
        service.delete(id);
    }
}
