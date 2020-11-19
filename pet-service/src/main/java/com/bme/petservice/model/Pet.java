package com.bme.petservice.model;


import lombok.Data;


import javax.persistence.*;


@Entity
@Data
@Table(name = "pet")
public class Pet {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String name;
		private String description;
		private int age;
		private String imageUrl;
		private String gender;
		private double weight;
		
		@ManyToOne
		@JoinColumn(nullable = false)
		private Type typeOfPet;
}
