package com.bme.petservice.model;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "type")
public class Type {
		@Id
		private int id;
		
		private String typeName;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOfPet")
		private List<Pet> pets;
}
