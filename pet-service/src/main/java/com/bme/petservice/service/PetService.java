package com.bme.petservice.service;


import com.bme.petservice.dto.AddPetResource;
import com.bme.petservice.mapper.PetMapper;
import com.bme.petservice.model.Pet;
import com.bme.petservice.repository.PetRepository;
import com.bme.shelterservice.feign.ShelterServiceIF;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository repository;
    private PetMapper mapper;
    private ShelterServiceIF serviceIF;

    @PostConstruct
    public void mock() {
        Pet petEntity = new Pet();
        petEntity.setId(1);
        petEntity.setName("Mimi");
        petEntity.setAge(2);
        petEntity.setGender("Male");
        petEntity.setTypeOfPet("Cat");
        petEntity.setImageUrl("assets/images/pets/KYEJp9vem3QQFGhi25SYx4-1200-80.jpg");
        repository.save(petEntity);

        Pet petEntity2 = new Pet();
        petEntity2.setId(2);
        petEntity2.setName("Max");
        petEntity2.setAge(3);
        petEntity2.setGender("Female");
        petEntity2.setTypeOfPet("Dog");
        petEntity2.setImageUrl("assets/images/pets/dog.png");
        repository.save(petEntity2);

        Pet petEntity3 = new Pet();
        petEntity3.setId(3);
        petEntity3.setName("Korp");
        petEntity3.setAge(3);
        petEntity3.setGender("Female");
        petEntity3.setTypeOfPet("Cat");
        petEntity3.setImageUrl("assets/images/pets/cat2.png");
        petEntity3.setWeight(3);
        repository.save(petEntity3);
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
