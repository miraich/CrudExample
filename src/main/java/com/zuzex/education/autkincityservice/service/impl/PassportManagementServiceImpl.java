package com.zuzex.education.autkincityservice.service.impl;

import com.zuzex.education.autkincityservice.model.Passport;
import com.zuzex.education.autkincityservice.service.PassportManagementService;
import com.zuzex.education.autkincityservice.service.entity.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class PassportManagementServiceImpl implements PassportManagementService {
    private final PassportService passportService;

    @Override
    public Set<Passport> getPassportsBySurnameLetter(String gender, Character letter) {
        return passportService.getPassportsBySurnameLetter(gender, letter);
    }
}
