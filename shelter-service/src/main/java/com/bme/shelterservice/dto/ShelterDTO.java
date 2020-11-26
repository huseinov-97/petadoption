package com.bme.shelterservice.dto;


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
		private String name;
		
		@NotNull
		@NotEmpty
		private String email;
		
		@NotNull
		@NotEmpty
		private String phoneNumber;
		
		private String description;
		
		@NotNull
		@NotEmpty
		private String address;
		
		@NotNull
		@NotEmpty
		private String imageUrl;
		
		@ElementCollection
		private List<UUID> pets;
		
}
