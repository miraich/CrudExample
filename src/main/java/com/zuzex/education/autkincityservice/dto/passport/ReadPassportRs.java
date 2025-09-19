package com.zuzex.education.autkincityservice.dto.passport;

import com.zuzex.education.autkincityservice.dto.address.AddressDto;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Jacksonized
@Builder(toBuilder = true)
public record ReadPassportRs(
        AddressDto address,

        String gender,

        LocalDate birthDate,

        String firstName,

        String lastName
) {
}
