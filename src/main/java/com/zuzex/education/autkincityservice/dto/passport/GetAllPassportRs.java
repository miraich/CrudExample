package com.zuzex.education.autkincityservice.dto.passport;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder(toBuilder = true)
public record GetAllPassportRs(
        Set<PassportDto> passports
) {
}
