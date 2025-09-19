package com.zuzex.education.autkincityservice.dto.resident;

import com.zuzex.education.autkincityservice.dto.passport.PassportDto;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder(toBuilder = true)
public record ReadResidentRs(
        UUID id,

        String phone,

        String email,

        PassportDto passport
) {
}
