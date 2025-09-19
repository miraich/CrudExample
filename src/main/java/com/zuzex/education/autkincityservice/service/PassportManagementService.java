package com.zuzex.education.autkincityservice.service;

import com.zuzex.education.autkincityservice.model.Passport;

import java.util.Set;

public interface PassportManagementService {
    Set<Passport> getPassportsBySurnameLetter(String gender, Character letter);
}
