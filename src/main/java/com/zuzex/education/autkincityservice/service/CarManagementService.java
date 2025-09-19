package com.zuzex.education.autkincityservice.service;

import com.zuzex.education.autkincityservice.model.Car;

import java.util.UUID;

public interface CarManagementService {
    Car addOwner(UUID carId, UUID residentId);
}
