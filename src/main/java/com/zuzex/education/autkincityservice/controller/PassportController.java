package com.zuzex.education.autkincityservice.controller;

import com.zuzex.education.autkincityservice.dto.passport.GetAllPassportRs;
import com.zuzex.education.autkincityservice.mapper.PassportMapper;
import com.zuzex.education.autkincityservice.service.PassportManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/passports")
@RequiredArgsConstructor
public class PassportController {
    private final PassportMapper passportMapper;
    private final PassportManagementService passportManagementService;

    @GetMapping("/gender/{gender}/surname/{letter}")
    public GetAllPassportRs getPassportsBySurnameLetter(
            @PathVariable String gender,
            @PathVariable Character letter
    ) {
        return GetAllPassportRs.builder().passports(
                passportMapper.map(passportManagementService.getPassportsBySurnameLetter(gender, letter))
        ).build();
    }
}
