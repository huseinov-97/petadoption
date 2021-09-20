package com.bme.authserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldNameConstants
public class UpdateUserResource {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
