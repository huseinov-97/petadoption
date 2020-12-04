package com.bme.shelterservice.controller;


import com.bme.shelterservice.dto.ShelterDTO;
import com.bme.shelterservice.dto.ShelterPrivateDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ShelterMapper {
		
		ShelterDTO shelterPrivateDTOToDTO(ShelterPrivateDTO privateDTO);
		
}
