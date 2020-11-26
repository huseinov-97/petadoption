package com.bme.shelterservice.dto;


import lombok.*;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ShelterPrivateDTO extends ShelterDTO {
		
		private int maxSize;
		private String postalCode;
		private String ownerName;
		
}
