package com.bme.authserver.feign;


import com.bme.authserver.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@FeignClient(
		name = "auth-server",
		url = "${services.auth-server-url:localhost:8083}/users"
)
public interface UserServiceIF {
		@GetMapping("/{id}")
		ResponseEntity<UserDTO> findOneUser(@PathVariable UUID id);
}
