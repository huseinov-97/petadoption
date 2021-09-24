package com.bme.authserver.dto;


import com.bme.authserver.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResource {
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;

    public static UserResource toUserResource(User user) {
        return UserResource.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
