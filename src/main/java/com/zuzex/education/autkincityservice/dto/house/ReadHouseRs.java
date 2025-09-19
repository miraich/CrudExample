package com.zuzex.education.autkincityservice.dto.house;

import com.zuzex.education.autkincityservice.dto.address.AddressDto;
import com.zuzex.education.autkincityservice.dto.resident.ResidentDto;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Set;

@Jacksonized
@Builder(toBuilder = true)
public record ReadHouseRs(
        AddressDto address,

        Set<ResidentDto> residents,

        BigDecimal price
) {
}
