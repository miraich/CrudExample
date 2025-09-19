package com.zuzex.education.autkincityservice.service.impl;

import com.zuzex.education.autkincityservice.exception.EntityNotFoundException;
import com.zuzex.education.autkincityservice.exception.RelationForUserAlreadyExistException;
import com.zuzex.education.autkincityservice.exception.RelationForUserNotExistException;
import com.zuzex.education.autkincityservice.model.House;
import com.zuzex.education.autkincityservice.model.Resident;
import com.zuzex.education.autkincityservice.service.HouseManagementService;
import com.zuzex.education.autkincityservice.service.entity.AddressService;
import com.zuzex.education.autkincityservice.service.entity.HouseService;
import com.zuzex.education.autkincityservice.service.entity.ResidentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseManagementServiceImpl implements HouseManagementService {
    private final ResidentService residentService;
    private final HouseService houseService;
    private final AddressService addressService;

    @Override
    public House create(House house) {
        if (!addressService.exists(house.getAddress().getId())) {
            throw new EntityNotFoundException(String.format("Address %s isn't found in repository",
                    house.getAddress().getId()));
        }
        return houseService.save(house);
    }

    @Override
    public House addOwner(UUID residentId, UUID houseId) {
        House house = houseService.get(houseId);
        Resident resident = residentService.get(residentId);
        if (house.getResidents().contains(resident)) {
            throw new RelationForUserAlreadyExistException(String.format("House %s already contains %s resident",
                    houseId, residentId));
        }
        resident.getHouses().add(house);
        house.getResidents().add(resident);
        return houseService.save(house);
    }

    @Override
    public House update(House house, UUID houseId) {
        if (!addressService.exists(house.getAddress().getId())) {
            throw new EntityNotFoundException(String.format("Address %s isn't found in repository",
                    house.getAddress().getId()));
        }
        if (!houseService.exists(houseId)) {
            throw new EntityNotFoundException(String.format("House %s not found in repository", houseId));
        }
        house.setId(houseId);
        return houseService.save(house);
    }

    @Override
    @Transactional
    public void delete(UUID houseId) {
        House house = houseService.get(houseId);
        for (Resident resident : house.getResidents()) {
            resident.getHouses().remove(house);
        }
        house.getResidents().clear();
        houseService.delete(house);
    }

    @Transactional
    @Override
    public void deleteOwner(UUID residentId, UUID houseId) {
        House house = houseService.get(houseId);
        Resident resident = residentService.get(residentId);
        if (!house.getResidents().contains(resident)) {
            throw new RelationForUserNotExistException(String.format("House %s not contain %s resident",
                    houseId, residentId));
        }
        resident.getHouses().remove(house);
        house.getResidents().remove(resident);
        houseService.save(house);
    }
}
