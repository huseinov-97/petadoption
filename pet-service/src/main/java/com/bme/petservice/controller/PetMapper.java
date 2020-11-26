package com.bme.petservice.controller;


import com.bme.petservice.dto.PetDto;
import com.bme.petservice.model.Pet;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PetMapper {
		
		PetDto petToPublicDTO(Pet entity);
		
}
