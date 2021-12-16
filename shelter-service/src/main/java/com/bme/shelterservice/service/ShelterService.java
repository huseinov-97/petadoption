package com.bme.shelterservice.service;

import com.bme.shelterservice.dto.AddShelterResource;
import com.bme.shelterservice.dto.ShelterResource;
import com.bme.shelterservice.dto.UpdateShelterResource;

import java.util.List;

public interface ShelterService {

    List<ShelterResource> list();

    ShelterResource get(Integer id);

    ShelterResource create(AddShelterResource addShelterResource);

    ShelterResource update(UpdateShelterResource updateShelterResource, Integer id);

    void delete(Integer id);
}
