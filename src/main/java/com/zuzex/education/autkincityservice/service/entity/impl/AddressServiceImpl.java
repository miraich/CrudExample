package com.zuzex.education.autkincityservice.service.entity.impl;

import com.zuzex.education.autkincityservice.repository.AddressRepository;
import com.zuzex.education.autkincityservice.service.entity.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public boolean exists(UUID addressId) {
        return addressRepository.existsById(addressId);
    }
}
