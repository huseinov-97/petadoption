package com.bme.petservice.mapper;


import com.bme.petservice.dto.AddPetResource;
import com.bme.petservice.dto.PetResource;
import com.bme.petservice.model.Pet;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PetMapper {
    PetResource to(Pet entity);

    Pet from(AddPetResource addPetResource);

    @AfterMapping
    default void afterFrom(@MappingTarget Pet pet, AddPetResource addPetResource){
    }
}
