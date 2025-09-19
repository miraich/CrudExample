package com.zuzex.education.autkincityservice.service.entity.impl;

import com.zuzex.education.autkincityservice.exception.EntityNotFoundException;
import com.zuzex.education.autkincityservice.model.Car;
import com.zuzex.education.autkincityservice.repository.CarRepository;
import com.zuzex.education.autkincityservice.service.entity.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car get(UUID carId) {
        return carRepository.findById(carId).orElseThrow(() ->
                new EntityNotFoundException(
                        String.format("Car %s isn't found", carId)
                ));
    }

    @Override
    public Set<Car> getCarsByResidentId(UUID residentId) {
        return carRepository.getCarsByResidentId(residentId);
    }

    @Override
    public Car update(Car car, UUID carId) {
        if (!exists(carId)) {
            throw new EntityNotFoundException(String.format("Car %s not found", carId));
        }
        car.setId(carId);
        return save(car);
    }

    @Override
    public void delete(UUID carId) {
        carRepository.delete(get(carId));
    }

    @Override
    public void deleteAll(Set<Car> cars) {
        carRepository.deleteAllInBatch(cars);
    }

    @Override
    public boolean exists(UUID carId) {
        return carRepository.existsById(carId);
    }
}
