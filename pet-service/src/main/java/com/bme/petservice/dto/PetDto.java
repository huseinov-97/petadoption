package com.bme.petservice.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


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
		@NotEmpty
		private String type;
		
}
