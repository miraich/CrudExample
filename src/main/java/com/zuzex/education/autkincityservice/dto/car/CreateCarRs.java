package com.zuzex.education.autkincityservice.dto.car;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Builder(toBuilder = true)
public record CreateCarRs(
        String color,

        String brand,

        BigDecimal price
) {
}
