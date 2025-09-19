package com.zuzex.education.autkincityservice.service.entity;

import com.zuzex.education.autkincityservice.model.Passport;

import java.util.Set;
import java.util.UUID;

public interface PassportService {
    Passport save(Passport passport);

    Set<Passport> getPassportsBySurnameLetter(String gender, Character letter);

    void delete(Passport passport);

    boolean exists(UUID passportId);
}
