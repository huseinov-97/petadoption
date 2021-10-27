package com.bme.petservice.dto;


import com.bme.shelterservice.dto.ShelterResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPetResource {
    private String name;
    private int age;
    private String type;
    private String gender;

    private ShelterResource shelterResource;
}
