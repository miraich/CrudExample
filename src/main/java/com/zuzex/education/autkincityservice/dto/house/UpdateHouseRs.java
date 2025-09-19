package com.zuzex.education.autkincityservice.dto.house;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.UUID;

@Jacksonized
@Builder(toBuilder = true)
public record UpdateHouseRs(
        UUID addressId,

        BigDecimal price
) {
}
