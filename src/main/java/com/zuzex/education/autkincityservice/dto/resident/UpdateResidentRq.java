package com.zuzex.education.autkincityservice.dto.resident;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(toBuilder = true)
public record UpdateResidentRq(
        @NotBlank
        @Pattern(regexp = "^\\+?[0-9\\-\\s()]{10,20}$")
        String phone,

        @NotBlank
        @Email
        String email
) {
}
