package com.bme.shelterservice.mapper;

import com.bme.shelterservice.dto.AddShelterResource;
import com.bme.shelterservice.dto.ShelterResource;
import com.bme.shelterservice.model.Shelter;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ShelterMapper {
    ShelterResource toResource(Shelter shelter);

    Shelter fromResource(AddShelterResource addShelterResource);

    @AfterMapping
    default void afterFromResource(@MappingTarget Shelter shelter, AddShelterResource addShelterResource){
        shelter.setCreateDate(Instant.now());
    }
}
