package com.bme.authserver.service;


import com.bme.authserver.entity.User;
import com.bme.authserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @PostConstruct
    public void mock() {

        User userEntity = new User();
        userEntity.setFirstName("Mahir");
        userEntity.setLastName("Huseynov");
        userEntity.setEnabled(true);
        userRepository.save(userEntity);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);

        if (user.isPresent()) {
            return (UserDetails) user.get();
        } else {
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
    }
}
