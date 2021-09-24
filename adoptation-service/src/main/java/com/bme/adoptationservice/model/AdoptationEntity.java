package com.bme.adoptationservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
public class AdoptationEntity {
		
		@Id
		private UUID id = UUID.randomUUID();
		private boolean isAdopted;
		
		
		private Date adoptationDate;
		
		/**
		 * ID of the pets of the shelter.
		 */
		@ElementCollection
		private List<Integer> pets;
		

}
