package com.bme.petservice.service;


import com.bme.petservice.dto.AddPetResource;
import com.bme.petservice.mapper.PetMapper;
import com.bme.petservice.model.Pet;
import com.bme.petservice.repository.PetRepository;
import com.bme.shelterservice.feign.ShelterServiceIF;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository repository;
    private PetMapper mapper;
    private ShelterServiceIF serviceIF;

    @PostConstruct
    public void mock() {
        Pet petEntity = new Pet();
        petEntity.setName("Pet 1");
        petEntity.setAge(2);
        petEntity.setGender("Male");
        petEntity.setTypeOfPet("cat");
        repository.save(petEntity);
    }

    public List<Pet> list() {
        return repository.findAll();
    }

    public Optional<Pet> get(Integer id) {
        return repository.findById(id);
    }

    public Pet create(AddPetResource addPetResource) {
        Pet entity = mapper.from(addPetResource);
        entity.setShelterId(serviceIF.get(addPetResource.getShelterResource().getId()).getId());
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
