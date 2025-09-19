package com.zuzex.education.autkincityservice.service.entity;

import com.zuzex.education.autkincityservice.model.House;

import java.util.Set;
import java.util.UUID;

public interface HouseService {
    House get(UUID houseId);

    Set<House> getAll();

    House update(House house, UUID houseId);

    void delete(House house);

    House save(House house);

    boolean exists(UUID houseId);
}
