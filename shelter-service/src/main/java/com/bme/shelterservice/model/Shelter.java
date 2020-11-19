package com.bme.shelterservice.model;


import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Shelter {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column
		private int id;
		
		@Column
		private String shelterName;
		
		@Column
		private String ownerName;

		@Column
		private String lastName;
		
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
		
		
}
