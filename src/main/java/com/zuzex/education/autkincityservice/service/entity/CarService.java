package com.zuzex.education.autkincityservice.service.entity;

import com.zuzex.education.autkincityservice.model.Car;

import java.util.Set;
import java.util.UUID;

public interface CarService {
    Car save(Car car);

    Car get(UUID carId);

    Set<Car> getCarsByResidentId(UUID residentId);

    Car update(Car car, UUID carId);

    void delete(UUID carId);

    void deleteAll(Set<Car> cars);

    boolean exists(UUID carId);
}
