package com.zuzex.education.autkincityservice.dto.address;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder(toBuilder = true)
public record ReadAddressRs(
        UUID id,

        String country,

        String city,

        String street,

        String house
) {
}
