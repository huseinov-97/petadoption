package com.bme.petservice.controller;


import com.bme.petservice.dto.PetDto;
import com.bme.petservice.model.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PetMapper {
	@Mapping(target = "id", expression = "java(entity.getId().toString())")
	PetDto petToPublicDTO(Pet entity);
		
}
