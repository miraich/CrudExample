package com.zuzex.education.autkincityservice.dto.car;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Builder(toBuilder = true)
public record UpdateCarRq(
        @NotBlank
        @Size(min = 3, max = 30)
        String color,

        @NotBlank
        @Size(min = 3, max = 20)
        String brand,

        @NotNull
        @DecimalMin("100.00")
        BigDecimal price
) {
}
