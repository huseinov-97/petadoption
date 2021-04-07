package com.bme.authserver.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
public class User {
	@Id
	private UUID id	= UUID.randomUUID();
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	@Email
	private String email;
	
	private boolean enabled;
	
	private boolean isAdmin;
	
	private LocalDate registrationDate;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	public User(){
			registrationDate = LocalDate.now();
	}
	
	public void grantAuthority(Role authority){
			if (roles == null){
					roles = new ArrayList<>();
			}
			roles.add(authority);
	}
	
	public List<GrantedAuthority> getAuthorities(){
			List<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.toString())));
			return authorities;
	}
}
