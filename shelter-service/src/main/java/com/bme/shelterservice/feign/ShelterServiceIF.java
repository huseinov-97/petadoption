package com.bme.shelterservice.feign;

import com.bme.shelterservice.dto.ShelterResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "shelter-service",
        url = "${services.shelter-service-url:localhost:8084}/shelters"
)
public interface ShelterServiceIF {
    @GetMapping("/{id}")
    ShelterResource get(@PathVariable Integer id);
}
