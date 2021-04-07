package com.bme.authserver.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
		
		@NotNull
		private String id;
		
		@NotNull
		private String name;
		
		@NotNull
		private String lastName;
		
		@NotNull
		private String email;
		
		
}
