package com.bme.authserver.mapper;

import com.bme.authserver.dto.AddUserResource;
import com.bme.authserver.dto.UserResource;
import com.bme.authserver.entity.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResource to(User user);

    User from(AddUserResource addUserResource);

    @AfterMapping
    default void afterFrom(@MappingTarget User user, AddUserResource addUserResource){
        user.setAdmin(false);
        user.setEnabled(true);
        user.setRegistrationDate(Instant.now());
    }
}
