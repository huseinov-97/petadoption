package com.bme.userservice.feign;


import com.bme.userservice.dto.UserResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@FeignClient(
        name = "auth-server",
        url = "${services.auth-server-url:localhost:8083}/users"
)
public interface UserServiceIF {
    @GetMapping("/{id}")
    ResponseEntity<Optional<UserResource>> get(@PathVariable Integer id);
}
