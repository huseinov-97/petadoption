package com.bme.petservice.feignclient;


import com.bme.petservice.dto.PetResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@FeignClient(
        name = "pet-service",
        url = "${services.pet-service-url:localhost:8083}/pets"
)
public interface PetServiceIF {
    @GetMapping("/{id}")
    ResponseEntity<PetResource> get(@PathVariable Integer id);
}
