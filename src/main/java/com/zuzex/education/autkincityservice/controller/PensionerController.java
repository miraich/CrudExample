package com.zuzex.education.autkincityservice.controller;

import com.zuzex.education.autkincityservice.dto.resident.ReadResidentRs;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/pensioners")
@RequiredArgsConstructor
public class PensionerController {

    @PostMapping("/pension/credit")
    public void creditPension() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/city/{cityName}")
    public Set<ReadResidentRs> getPensionersByCity(
            @PathVariable String cityName
    ) {
        throw new UnsupportedOperationException();
    }
}
