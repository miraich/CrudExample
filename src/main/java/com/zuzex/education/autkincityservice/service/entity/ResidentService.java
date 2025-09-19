package com.zuzex.education.autkincityservice.service.entity;

import com.zuzex.education.autkincityservice.model.Resident;

import java.util.Set;
import java.util.UUID;

public interface ResidentService {
    Resident save(Resident resident);

    Resident get(UUID residentId);

    Set<Resident> getAllWithPassport();

    Set<Resident> getHouseOwnersByStreet(String street);

    Resident update(Resident resident, UUID residentId);

    void delete(Resident resident);

    boolean exists(UUID residentId);
}
