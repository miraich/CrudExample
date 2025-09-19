package com.zuzex.education.autkincityservice.dto.resident;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder(toBuilder = true)
public record GetAllResidentRs(
        Set<ResidentDto> residents
) {
}
