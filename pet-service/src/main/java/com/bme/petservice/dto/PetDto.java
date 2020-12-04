package com.bme.petservice.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
		
		@NotNull
		private String id;
		
		@NotNull
		private String name;
		
		private String description;
		
		@NotEmpty
		@NotNull
		private int age;
		
		private String imageUrl;
		
		@NotNull
		@NotEmpty
		private String gender;
		
		private double weight;
		
		@NotNull
		private String type;
		
}
