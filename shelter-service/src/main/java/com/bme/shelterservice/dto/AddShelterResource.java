package com.bme.shelterservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;


@Data
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddShelterResource {
    private String shelterName;
    private String ownerName;
    private String address;
    private String description;
    private String phoneNumber;
    private String email;
    private Integer maxSize;
}
