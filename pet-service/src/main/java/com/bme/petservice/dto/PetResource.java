package com.bme.petservice.dto;


import com.bme.petservice.model.Pet;
import com.bme.shelterservice.dto.ShelterResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetResource {
    private Integer id;
    private String name;
    private String description;
    private Integer age;
    private String imageUrl;
    private String gender;
    private Integer weight;
    private String type;
    private ShelterResource shelterResource;

    public static PetResource toPetResource(Pet pet) {
        return PetResource.builder()
                .name(pet.getName())
                .description(pet.getDescription())
                .age(pet.getAge())
                .imageUrl(pet.getImageUrl())
                .gender(pet.getGender())
                .weight(pet.getWeight())
                .type(pet.getTypeOfPet())
                .build();
    }
}
