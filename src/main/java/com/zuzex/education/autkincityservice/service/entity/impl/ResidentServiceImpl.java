package com.zuzex.education.autkincityservice.service.entity.impl;

import com.zuzex.education.autkincityservice.exception.EntityNotFoundException;
import com.zuzex.education.autkincityservice.model.Resident;
import com.zuzex.education.autkincityservice.repository.ResidentRepository;
import com.zuzex.education.autkincityservice.service.entity.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResidentServiceImpl implements ResidentService {
    private final ResidentRepository residentRepository;

    @Override
    public Resident save(Resident resident) {
        return residentRepository.save(resident);
    }

    @Override
    public Resident get(UUID residentId) {
        return residentRepository.findById(residentId).orElseThrow(() ->
                new EntityNotFoundException(String.format("Resident with id %s not found", residentId)));
    }

    @Override
    public Set<Resident> getAllWithPassport() {
        return residentRepository.getAllWithPassport();
    }

    @Override
    public Set<Resident> getHouseOwnersByStreet(String street) {
        return residentRepository.getHouseOwnersByStreet(street);
    }

    @Override
    public Resident update(Resident resident, UUID residentId) {
        if (!exists(residentId)) {
            throw new EntityNotFoundException(String.format("Resident %s not found", residentId));
        }
        resident.setId(residentId);
        return residentRepository.save(resident);
    }

    @Override
    public void delete(Resident resident) {
        residentRepository.delete(resident);
    }

    @Override
    public boolean exists(UUID residentId) {
        return residentRepository.existsById(residentId);
    }
}
