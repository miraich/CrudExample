package com.zuzex.education.autkincityservice.service.impl;

import com.zuzex.education.autkincityservice.model.Car;
import com.zuzex.education.autkincityservice.model.Resident;
import com.zuzex.education.autkincityservice.service.CarManagementService;
import com.zuzex.education.autkincityservice.service.entity.CarService;
import com.zuzex.education.autkincityservice.service.entity.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarManagementServiceImpl implements CarManagementService {
    private final CarService carService;
    private final ResidentService residentService;

    @Override
    public Car addOwner(UUID carId, UUID residentId) {
        Car car = carService.get(carId);
        Resident resident = residentService.get(residentId);
        car.setResident(resident);
        return carService.save(car);
    }
}
