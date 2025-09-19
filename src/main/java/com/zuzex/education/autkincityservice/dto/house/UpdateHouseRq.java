package com.zuzex.education.autkincityservice.dto.house;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Jacksonized
@Builder(toBuilder = true)
public record UpdateHouseRq(
        @NotNull
        UUID addressId,

        @NotNull
        @DecimalMin("1000.00")
        BigDecimal price
) {
}
