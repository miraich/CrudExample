package com.zuzex.education.autkincityservice.service;

import com.zuzex.education.autkincityservice.model.Resident;

import java.util.UUID;

public interface ResidentManagementService {
    void delete(UUID residentId);

    Resident createResidentWithPassport(Resident resident);
}
