package com.zuzex.education.autkincityservice.dto.car;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder(toBuilder = true)
public record GetAllCarRs(
        Set<CarDto> cars
) {
}
