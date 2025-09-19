package com.zuzex.education.autkincityservice.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Jacksonized
@Builder(toBuilder = true)
public record AddressDto(
        @NotNull
        UUID id,

        @NotBlank
        @Size(min = 3, max = 255)
        String country,

        @NotBlank
        @Size(min = 3, max = 255)
        String city,

        @NotBlank
        @Size(min = 3, max = 255)
        String street,

        @NotBlank
        @Size(min = 3, max = 255)
        String house
) {
}
