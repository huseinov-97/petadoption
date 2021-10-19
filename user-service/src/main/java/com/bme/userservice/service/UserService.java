package com.bme.userservice.service;


import com.bme.userservice.dto.AddUserResource;
import com.bme.userservice.dto.UpdateUserResource;
import com.bme.userservice.dto.UserResource;
import com.bme.userservice.entity.Role;
import com.bme.userservice.entity.User;
import com.bme.userservice.exception.UserNotFoundException;
import com.bme.userservice.mapper.UserMapper;
import com.bme.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void mock() {
        User user = User.builder()
                .id(1)
                .firstName("Mahir")
                .lastName("huseynov")
                .userName("huseynov")
                .password(passwordEncoder.encode("test"))
                .email("mahir@gmail.com")
                .isAdmin(false)
                .build();

        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUserName(s);

        if (user.isPresent()) {
            User petUser = user.get();

            // We map our custom User object to the User defined by spring security
            return org.springframework.security.core.userdetails.User
                    .withUsername(petUser.getUserName())
                    .password(petUser.getPassword())
                    .roles(petUser.getRoles().stream().map(Role::getName).collect(Collectors.toList()).toArray(new String[]{}))
                    .build();
        } else {
            throw new UsernameNotFoundException(String.format("Username[%s] not found", s));
        }
    }

    public List<User> list() {
        return repository.findAll();
    }

    public Optional<User> get(Integer id) {
        return repository.findById(id);
    }

    public UserResource create(AddUserResource addUserResource) {
        User user = mapper.from(addUserResource);
        user = repository.save(user);
        return mapper.to(user);
    }

    public UserResource update(Integer id, UpdateUserResource updateUserResource) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setFirstName(updateUserResource.getFirstName());
        user.setLastName(updateUserResource.getLastName());
        user.setEmail(updateUserResource.getEmail());
        user.setPassword(updateUserResource.getPassword());

        User updatedUser = repository.save(user);
        return mapper.to(updatedUser);
    }
}
