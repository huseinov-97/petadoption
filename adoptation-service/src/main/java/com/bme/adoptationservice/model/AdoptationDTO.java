package com.bme.adoptationservice.model;


import com.bme.petservice.dto.PetResource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Data
public class AdoptationDTO {
				private String id;
		private boolean isAdopted;
		private Date adoptationDate;
		private List<PetResource> pets;
}
