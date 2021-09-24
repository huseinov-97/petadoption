package com.bme.shelterservice.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
public class Shelter {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column
		private UUID id;
		
		@Column
		private String shelterName;
		
		@Column
		private String ownerName;
		
		@Column
		private String address;
		
		@Column
		private String description;
		
		@Column
		private String phoneNumber;
		
		@Column
		private String email;
		
		@Column
		private String postalCode;
		
		@Column
		private int maxSize;
		
		@Column
		@UpdateTimestamp
		private Date lastUpdated;
		
		@Column
		private String imageUrl;
		
		/**
		 * ID of the pets of the shelter.
		 */
		@ElementCollection
		private List<Integer> pets;
		
		
		
		
}
