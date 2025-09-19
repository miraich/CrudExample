package com.zuzex.education.autkincityservice.service.entity.impl;

import com.zuzex.education.autkincityservice.exception.EntityNotFoundException;
import com.zuzex.education.autkincityservice.model.House;
import com.zuzex.education.autkincityservice.repository.HouseRepository;
import com.zuzex.education.autkincityservice.service.entity.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public House get(UUID houseId) {
        return houseRepository.findById(houseId).orElseThrow(() ->
                new EntityNotFoundException(
                        String.format("House %s isn't found", houseId)
                ));
    }

    @Override
    public Set<House> getAll() {
        return new HashSet<>(houseRepository.findAll());
    }

    @Override
    public House update(House house, UUID houseId) {
        return save(house);
    }

    @Override
    public void delete(House house) {
        houseRepository.delete(house);
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public boolean exists(UUID houseId) {
        return houseRepository.existsById(houseId);
    }
}
