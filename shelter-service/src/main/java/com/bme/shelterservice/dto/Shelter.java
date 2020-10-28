package com.bme.shelterservice.dto;


import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "shelter")
public class Shelter {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Long id;
		
		@Column(name = "shelter_name")
		private String shelterName;
		
		@Column(name = "first_name")
		private String firstName;

		@Column(name = "last_name")
		private String lastName;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "phone_number")
		private String phoneNumber;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "postal_code")
		private String postalCode;
		
		@Column(name = "max_size")
		private int maxSize;
		
		@Column(name = "last_updated")
		@UpdateTimestamp
		private Date lastUpdated;
		
		@Column(name = "image_url")
		private String imageUrl;
		
		
}
