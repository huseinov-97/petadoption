package com.bme.adoptationservice;

import com.bme.adoptationservice.dto.AddAdoptationResource;
import com.bme.adoptationservice.dto.AdoptationResource;
import com.bme.adoptationservice.model.AdoptationEntity;
import com.bme.petservice.dto.AddPetResource;
import com.bme.petservice.dto.PetResource;
import com.bme.petservice.model.Pet;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AdoptationMapper {
    AdoptationResource to(AdoptationEntity entity);

    AdoptationEntity from(AddAdoptationResource addAdoptationResource);

    @AfterMapping
    default void afterFrom(@MappingTarget AdoptationEntity pet, AddAdoptationResource addPetResource){
    }
}
