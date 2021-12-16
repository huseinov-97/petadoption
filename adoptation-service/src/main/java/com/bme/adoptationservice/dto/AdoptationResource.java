package com.bme.adoptationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdoptationResource {

    private Integer id;
    private boolean isAdopted;
    private Instant adoptationDate;
//    private List<PetResource> pets;
}
