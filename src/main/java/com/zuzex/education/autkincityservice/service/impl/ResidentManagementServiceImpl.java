package com.zuzex.education.autkincityservice.service.impl;

import com.zuzex.education.autkincityservice.exception.EntityNotFoundException;
import com.zuzex.education.autkincityservice.model.Car;
import com.zuzex.education.autkincityservice.model.House;
import com.zuzex.education.autkincityservice.model.Passport;
import com.zuzex.education.autkincityservice.model.Resident;
import com.zuzex.education.autkincityservice.service.ResidentManagementService;
import com.zuzex.education.autkincityservice.service.entity.AddressService;
import com.zuzex.education.autkincityservice.service.entity.CarService;
import com.zuzex.education.autkincityservice.service.entity.PassportService;
import com.zuzex.education.autkincityservice.service.entity.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResidentManagementServiceImpl implements ResidentManagementService {
    private final ResidentService residentService;
    private final PassportService passportService;
    private final AddressService addressService;
    private final CarService carService;

    @Override
    @Transactional
    public Resident createResidentWithPassport(Resident resident) {
        if (!addressService.exists(resident.getPassport().getAddress().getId())) {
            throw new EntityNotFoundException(String.format("Address %s isn't found in repository",
                    resident.getPassport().getAddress().getId()));
        }
        Passport passport = resident.getPassport();
        Passport savedPassport = passportService.save(passport);
        resident.setPassport(savedPassport);
        return residentService.save(resident);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public void delete(UUID residentId) {
        Resident resident = residentService.get(residentId);
        if (resident.getPassport() != null) {
            passportService.delete(resident.getPassport());
            resident.setPassport(null);
        }

        if (!CollectionUtils.isEmpty(resident.getCars())) {
            for (Car car : resident.getCars()) {
                car.setResident(null);
            }
            carService.deleteAll(resident.getCars());
        }

        if (!CollectionUtils.isEmpty(resident.getHouses())) {
            for (House house : new ArrayList<>(resident.getHouses())) {
                house.getResidents().remove(resident);
                resident.getHouses().remove(house);
            }
        }
        residentService.delete(resident);
    }
}
