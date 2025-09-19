package com.zuzex.education.autkincityservice.dto.car;

import com.zuzex.education.autkincityservice.dto.resident.ResidentDto;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Builder(toBuilder = true)
public record ReadCarRs(
        ResidentDto resident,

        String brand,

        String color,

        BigDecimal price
) {
}
