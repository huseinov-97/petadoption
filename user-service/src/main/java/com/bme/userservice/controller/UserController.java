package com.bme.userservice.controller;

import com.bme.userservice.dto.AddUserResource;
import com.bme.userservice.dto.UpdateUserResource;
import com.bme.userservice.dto.UserResource;
import com.bme.userservice.feign.UserServiceIF;
import com.bme.userservice.mapper.UserMapper;
import com.bme.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController implements UserServiceIF {

    private static final String PATH_ID = "/{id}";
    private static final String PARAM_ID = "id";
    private final UserService service;
    private final UserMapper mapper;

    // @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserResource>> list() {

        return ResponseEntity.ok(service.list().stream().map(UserResource::toUserResource).collect(Collectors.toList()));
    }

    //    @PreAuthoirze("hasAuthority('ADMIN')")
    @PostMapping
    public UserResource create(@RequestBody @Validated AddUserResource addUserResource) {
        return service.create(addUserResource);
    }

    @PutMapping(PATH_ID)
    public UserResource update(@PathVariable(PARAM_ID) Integer id, @RequestBody @Validated UpdateUserResource updateUserResource) {
        return service.update(id, updateUserResource);
    }

    @Override
    public ResponseEntity<Optional<UserResource>> get(Integer id) {
        return ResponseEntity.ok(service.get(id).map(mapper::to));
    }
}
