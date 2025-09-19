package com.zuzex.education.autkincityservice.dto.resident;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
public record UpdateResidentRs(
        String phone,

        String email
) {
}
