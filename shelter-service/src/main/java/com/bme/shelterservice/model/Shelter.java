package com.bme.shelterservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shelter {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_shelter")
		private Integer id;
		private String shelterName;
		private String ownerName;
		private String address;
		private String description;
		private String phoneNumber;
		private String email;
		private Integer maxSize;
		private Instant updateDate;
		private Instant createDate;
		private String imageUrl;

		@ElementCollection
		private List<Integer> pets;
		
		
		
		
}
