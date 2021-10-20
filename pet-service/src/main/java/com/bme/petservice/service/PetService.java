package com.bme.petservice.service;


import com.bme.petservice.dto.AddPetResource;
import com.bme.petservice.model.Pet;
import com.bme.petservice.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository repository;

//    @PostConstruct
//    public void mock() {
//        Pet petEntity = new Pet();
//        petEntity.setName("Pet 1");
//        petEntity.setId(UUID.fromString("3a142008-cffc-437e-bdeb-79a275f43c64"));
//        petEntity.setAge(2);
//        petEntity.setGender("Male");
//        petEntity.setTypeOfPet("cat");
//        repository.save(petEntity);
//    }

    public List<Pet> list() {
        return repository.findAll();
    }

    public Optional<Pet> get(Integer id) {
        return repository.findById(id);
    }

    public Pet create(AddPetResource dto) {
        Pet entity = new Pet();
        entity.setName(dto.getName());
//        entity.setTypeOfPet(dto.getType());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
