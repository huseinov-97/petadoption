package com.bme.adoptationservice.dto;


import com.bme.petservice.dto.PetResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptationResource {

    private Integer id;
    private boolean isAdopted;
    private Instant adoptationDate;
    private List<PetResource> pets;
}
