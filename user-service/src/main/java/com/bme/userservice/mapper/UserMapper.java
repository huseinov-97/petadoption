package com.bme.userservice.mapper;

import com.bme.userservice.dto.AddUserResource;
import com.bme.userservice.dto.UserResource;
import com.bme.userservice.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResource to(User user);

    User from(AddUserResource addUserResource);

    @AfterMapping
    default void afterFrom(@MappingTarget User user, AddUserResource addUserResource) {
        user.setAdmin(false);
        user.setEnabled(true);
        user.setRegistrationDate(Instant.now());
    }
}
