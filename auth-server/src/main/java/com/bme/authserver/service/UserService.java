package com.bme.authserver.service;


import com.bme.authserver.dto.AddUserResource;
import com.bme.authserver.dto.UpdateUserResource;
import com.bme.authserver.dto.UserResource;
import com.bme.authserver.entity.User;
import com.bme.authserver.exception.UserNotFoundException;
import com.bme.authserver.mapper.UserMapper;
import com.bme.authserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUserName(s);

        if (user.isPresent()) {
            return (UserDetails) user.get();
        } else {
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
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
