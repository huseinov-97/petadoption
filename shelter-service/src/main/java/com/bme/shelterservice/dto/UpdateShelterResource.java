package com.bme.shelterservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@FieldNameConstants
@Builder
public class UpdateShelterResource {

    private String shelterName;
    private String ownerName;
    private String address;
    private String description;
    private String phoneNumber;
    private String email;
    private Integer maxSize;
}
