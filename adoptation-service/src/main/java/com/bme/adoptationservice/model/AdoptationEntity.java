package com.bme.adoptationservice.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Data
public class AdoptationEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_adoptation")
		private Integer id;
		private boolean isAdopted;
		private Instant adoptationDate;
		
		/**
		 * ID of the pets of the shelter.
		 */
		@ElementCollection
		private List<Integer> pets;
		

}
