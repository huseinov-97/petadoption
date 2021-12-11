package com.bme.shelterservice.service.impl;


import com.bme.shelterservice.dto.AddShelterResource;
import com.bme.shelterservice.dto.ShelterResource;
import com.bme.shelterservice.dto.UpdateShelterResource;
import com.bme.shelterservice.exception.ShelterNotFoundException;
import com.bme.shelterservice.mapper.ShelterMapper;
import com.bme.shelterservice.model.Shelter;
import com.bme.shelterservice.repository.ShelterRepo;
import com.bme.shelterservice.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ShelterServiceImpl implements ShelterService {

    private final ShelterRepo repository;
    private final ShelterMapper mapper;

    @PostConstruct
    public void mock() {
        Shelter shelter = new Shelter();
        shelter.setId(1);
        shelter.setShelterName("Rescuers 1");
        shelter.setOwnerName("Mahir Huseynov");
        shelter.setAddress("Pecs");
        shelter.setDescription("Cat rescuers");
        shelter.setEmail("mhuseinov7@gmail.com");
        shelter.setMaxSize(100);
        shelter.setPhoneNumber("+36203333333");
        repository.save(shelter);

        Shelter shelter1 = new Shelter();
        shelter1.setId(2);
        shelter1.setShelterName("Rescuers");
        shelter1.setOwnerName("Mahir Huseynov");
        shelter1.setAddress("Budapest");
        shelter1.setDescription("Dog rescuers");
        shelter1.setEmail("mhuseinov7@gmail.com");
        shelter1.setMaxSize(100);
        shelter1.setPhoneNumber("+36203333333");
        repository.save(shelter1);

        Shelter shelter2 = new Shelter();
        shelter2.setId(3);
        shelter2.setShelterName("Rescuers world");
        shelter2.setOwnerName("Mahir Huseynov");
        shelter2.setAddress("Hungary");
        shelter2.setDescription("Dog and rescuers");
        shelter2.setEmail("mhuseinov7@gmail.com");
        shelter2.setMaxSize(200);
        shelter2.setPhoneNumber("+36203333333");
        repository.save(shelter2);
    }

    @Override
    public List<ShelterResource> list() {
        List<Shelter> shelters = repository.findAll();

        List<ShelterResource> shelterResources = shelters.stream()
                .map(mapper::toResource)
                .collect(Collectors.toList());

        return shelterResources;
    }

    @Override
    public ShelterResource get(Integer id) {
        log.trace("get shelter by id: {}", id);
        Shelter shelter = repository.findById(id)
                .orElseThrow(() -> new ShelterNotFoundException(id));
        return mapper.toResource(shelter);
    }

    @Override
    public ShelterResource create(AddShelterResource addShelterResource) {
        log.trace("create shelter with resources: {}", addShelterResource);


        Shelter shelter = mapper.fromResource(addShelterResource);
        repository.save(shelter);
        return mapper.toResource(shelter);
    }

    @Override
    public ShelterResource update(UpdateShelterResource updateShelterResource, Integer id) {
        log.trace("update shelter with params: {}", updateShelterResource);

        Shelter shelter = repository.findById(id)
                .orElseThrow(() -> new ShelterNotFoundException(id));
        shelter.setShelterName(updateShelterResource.getShelterName());
        shelter.setAddress(updateShelterResource.getAddress());
        shelter.setDescription(updateShelterResource.getDescription());
        shelter.setEmail(updateShelterResource.getEmail());
        shelter.setMaxSize(updateShelterResource.getMaxSize());
        shelter.setOwnerName(updateShelterResource.getOwnerName());
        shelter.setUpdateDate(Instant.now());

        repository.save(shelter);
        return mapper.toResource(shelter);
    }

    @Override
    public void delete(Integer id) {
        Shelter shelter = repository.findById(id)
                .orElseThrow(() -> new ShelterNotFoundException(id));

        repository.delete(shelter);
    }
}
