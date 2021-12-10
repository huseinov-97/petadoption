package com.bme.adoptationservice.service;


import com.bme.adoptationservice.AdoptationMapper;
import com.bme.adoptationservice.repo.AdoptationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdoptationService {

    private final AdoptationMapper mapper;
    private final AdoptationRepository repository;
//    private final PetServiceIF petService;

//    @PostConstruct
//    public void mock() {
//        AdoptationEntity adoptationEntity = new AdoptationEntity();
//        adoptationEntity.setAdopted(true);
//        adoptationEntity.setAdoptationDate(Instant.now());
//        repository.save(adoptationEntity);
//    }
//
//    public Page<AdoptationResource> findAll(Pageable pageable) {
//        return repository.findAll(pageable).map(entity -> {
//            AdoptationResource dto = new AdoptationResource();
//            dto.setPets(entity.getPets().stream()
//                    .map(petId -> petService.get(petId).getBody()).collect(Collectors.toList()));
//            return dto;
//        });
//    }
//
//    public Optional<AdoptationEntity> get(Integer id) {
//        return repository.findById(id);
//    }
//
//    public AdoptationResource create(AddAdoptationResource addAdoptationResource) {
//        AdoptationEntity entity = mapper.from(addAdoptationResource);
//
//        entity.setPets(petService.get(addAdoptationResource.getPets().get()));
//        return null;
//    }
//
//    public AdoptationResource createAdoptation(AdoptationResource adoptationResource) {
//
//        AdoptationEntity entity = mapper.from(adoptationResource);
//        entity.setShelterId(serviceIF.get(addPetResource.getShelterResource().getId()).getId());
////
////				dto.setAdoptationDate(date);
////				entity.setPets(dto.getPets().stream().map(p->
////						UUID.fromString(p.getId()))
////						.collect(Collectors.toList()));
//
//        return null;
//    }
//
//    public AdoptationResource update(AddAdoptationResource addAdoptationResource, Integer id) {
//    }
//
//    public void delete(Integer id) {
//    }
}
