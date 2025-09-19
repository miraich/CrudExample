package com.zuzex.education.autkincityservice.service;

import com.zuzex.education.autkincityservice.model.House;

import java.util.UUID;

public interface HouseManagementService {
    House create(House house);

    House addOwner(UUID residentId, UUID houseId);

    House update(House house, UUID houseId);

    void delete(UUID houseId);

    void deleteOwner(UUID residentId, UUID houseId);
}
