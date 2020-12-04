package com.bme.petservice.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
public class Pet {
		
		@Id
		private UUID id = UUID.randomUUID();
		
		@Column(nullable = false)
		private String name;
		
		private String description;
		
		private int age;
		
		private String imageUrl;
		
		@Column(nullable = false)
		private String gender;
		
		private double weight;
		
		private String typeOfPet;
}
