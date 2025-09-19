package com.zuzex.education.autkincityservice.dto.house;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder(toBuilder = true)
public record GetAllHouseRs(
        Set<HouseDto> houses
) {
}
