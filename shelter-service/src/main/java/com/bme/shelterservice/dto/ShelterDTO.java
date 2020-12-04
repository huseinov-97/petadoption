package com.bme.shelterservice.dto;


import com.bme.petservice.dto.PetDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShelterDTO {

		@NotNull
		private UUID id;

		@NotNull
		@NotEmpty
		private String shelterName;
		
		
		private String email;
		
		
		private String phoneNumber;
		
		private String description;
		
		
		private String address;
		
	
		private String imageUrl;
		
		@ElementCollection
		private List<PetDto> pets;
		
}
