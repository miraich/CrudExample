package com.zuzex.education.autkincityservice.service.entity.impl;

import com.zuzex.education.autkincityservice.model.Passport;
import com.zuzex.education.autkincityservice.repository.PassportRepository;
import com.zuzex.education.autkincityservice.service.entity.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Override
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Set<Passport> getPassportsBySurnameLetter(String gender, Character letter) {
        return passportRepository.getPassportsBySurnameLetter(gender, letter);
    }

    @Override
    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }

    @Override
    public boolean exists(UUID passportId) {
        return passportRepository.existsById(passportId);
    }
}
