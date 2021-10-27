package com.bme.petservice.model;


import com.bme.shelterservice.dto.ShelterResource;
import com.bme.shelterservice.model.Shelter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer age;
    private String imageUrl;
    private String gender;
    private Integer weight;
    private String typeOfPet;
    public Integer shelterId;
}
