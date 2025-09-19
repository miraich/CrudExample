package com.zuzex.education.autkincityservice.dto.passport;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.util.UUID;


@Jacksonized
@Builder(toBuilder = true)
public record CreatePassportRq(
        @NotNull
        UUID addressId,

        @NotNull
        @PastOrPresent
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate,

        @NotBlank
        @Size(min = 3, max = 255)
        String firstName,

        @NotBlank
        @Size(min = 3, max = 255)
        String lastName
) {
}
