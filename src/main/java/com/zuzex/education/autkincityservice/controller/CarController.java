package com.zuzex.education.autkincityservice.controller;

import com.zuzex.education.autkincityservice.dto.car.CreateCarRq;
import com.zuzex.education.autkincityservice.dto.car.CreateCarRs;
import com.zuzex.education.autkincityservice.dto.car.GetAllCarRs;
import com.zuzex.education.autkincityservice.dto.car.ReadCarRs;
import com.zuzex.education.autkincityservice.dto.car.UpdateCarRq;
import com.zuzex.education.autkincityservice.dto.car.UpdateCarRs;
import com.zuzex.education.autkincityservice.mapper.CarMapper;
import com.zuzex.education.autkincityservice.service.CarManagementService;
import com.zuzex.education.autkincityservice.service.entity.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarManagementService carManagementService;
    private final CarService carService;
    private final CarMapper carMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateCarRs create(@RequestBody @Valid CreateCarRq createCarRq) {
        return carMapper.mapToCreateRs(carService.save(carMapper.map(createCarRq)));
    }

    @PostMapping("/{carId}/residents/{residentId}")
    public UpdateCarRs addOwnerToCar(
            @PathVariable UUID carId,
            @PathVariable UUID residentId) {
        return carMapper.mapToUpdateRs(carManagementService.addOwner(carId, residentId));
    }

    @GetMapping("/residents/{residentId}")
    public GetAllCarRs getCarsByResidentId(@PathVariable UUID residentId) {
        return GetAllCarRs.builder().cars(
                carMapper.map(carService.getCarsByResidentId(residentId))
        ).build();
    }

    @GetMapping("/brand/{brandName}")
    public GetAllCarRs getCarsByBrand(@PathVariable UUID brandName) {
        throw new UnsupportedOperationException();
    }

    @PatchMapping("/brand/{brandId}")
    public void changeBrandName(@PathVariable UUID brandName) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/{carId}")
    public ReadCarRs get(@PathVariable UUID carId) {
        return carMapper.mapToReadCarRs(carService.get(carId));
    }

    @PatchMapping("/{carId}")
    public UpdateCarRs update(
            @PathVariable UUID carId,
            @RequestBody @Valid UpdateCarRq updateCarRq) {
        return carMapper.mapToUpdateRs(carService.update(carMapper.map(updateCarRq), carId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{carId}")
    public void delete(@PathVariable UUID carId) {
        carService.delete(carId);
    }
}
