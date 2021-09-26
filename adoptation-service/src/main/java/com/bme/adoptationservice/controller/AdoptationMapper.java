package com.bme.adoptationservice.controller;


import com.bme.adoptationservice.model.AdoptationDTO;
import com.bme.adoptationservice.model.AdoptationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AdoptationMapper {

//		@Mapping(target = "id", expression = "java(entity.getId().toString())")
//		AdoptationDTO convertToDTO(AdoptationEntity adoptationEntity);

}
