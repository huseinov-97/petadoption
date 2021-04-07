package com.bme.authserver.service;


import com.bme.authserver.entity.Role;
import com.bme.authserver.entity.User;
import com.bme.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;


public class UserService implements UserDetailsService {
		
		@Autowired
		private UserRepository userRepository;
		
		private Role role;
		
		@PostConstruct
		public void mock() {
				
				User userEntity = new User();
				userEntity.setFirstName("Mahir");
				userEntity.setLastName("Huseynov");
				userEntity.setId(UUID.fromString("3a142008-cffc-437e-bdeb-79a275f43c64"));
				userEntity.setEnabled(true);
				userEntity.setRoles(Collections.singletonList(role.ROLE_USER));
				userRepository.save(userEntity);
		}
		
		
		
		@Override
		public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				Optional<User> user = userRepository.findByUsername(s);
				
				if (user.isPresent()){
						return (UserDetails) user.get();
				}else{
						throw new UsernameNotFoundException(String.format("Username[%s] not found"));
				}
		}
}
