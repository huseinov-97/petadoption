package com.bme.adoptationservice.model;


import com.bme.petservice.dto.PetDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class AdoptationDTO {
		
		@NotNull
		private String id;
		
		private boolean isAdopted;
		private Date adoptationDate;
		
		private List<PetDto> pets;
}
