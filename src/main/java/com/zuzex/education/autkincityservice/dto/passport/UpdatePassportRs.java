package com.zuzex.education.autkincityservice.dto.passport;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.UUID;

@Jacksonized
@Builder(toBuilder = true)
public record UpdatePassportRs(
        UUID addressId,

        LocalDate birthDate,

        String firstName,

        String lastName
) {
}
