package com.bme.adoptationservice.controller;


import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AdoptationMapper {

//		@Mapping(target = "id", expression = "java(entity.getId().toString())")
//		AdoptationDTO convertToDTO(AdoptationEntity adoptationEntity);

}
