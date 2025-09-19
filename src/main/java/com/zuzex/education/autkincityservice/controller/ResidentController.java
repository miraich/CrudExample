package com.zuzex.education.autkincityservice.controller;

import com.zuzex.education.autkincityservice.dto.resident.CreateResidentRq;
import com.zuzex.education.autkincityservice.dto.resident.CreateResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.GetAllResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.ReadResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.UpdateResidentRq;
import com.zuzex.education.autkincityservice.dto.resident.UpdateResidentRs;
import com.zuzex.education.autkincityservice.mapper.ResidentMapper;
import com.zuzex.education.autkincityservice.service.ResidentManagementService;
import com.zuzex.education.autkincityservice.service.entity.ResidentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/residents")
@RequiredArgsConstructor
public class ResidentController {
    private final ResidentManagementService residentManagementService;
    private final ResidentService residentService;
    private final ResidentMapper residentMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateResidentRs create(@RequestBody @Valid CreateResidentRq createResidentRq) {
        return residentMapper.mapToCreateRs(
                residentManagementService.createResidentWithPassport(residentMapper.map(createResidentRq)
                ));
    }

    @GetMapping("/{residentId}")
    public ReadResidentRs get(@PathVariable UUID residentId) {
        return residentMapper.mapToReadRs(residentService.get(residentId));
    }

    @GetMapping
    public GetAllResidentRs getAllResidentRs() {
        return GetAllResidentRs.builder().residents(residentMapper.map(residentService.getAllWithPassport())).build();
    }

    @GetMapping("/city/{cityName}/count")
    public Set<ReadResidentRs> getResidentsCountByCity(
            @PathVariable String cityName
    ) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/houses/street/{street}")
    public GetAllResidentRs getHouseOwnersByStreet(@PathVariable String street) {
        return GetAllResidentRs.builder().residents(
                residentMapper.map(residentService.getHouseOwnersByStreet(street))
        ).build();
    }

    @PatchMapping("/{residentId}")
    public UpdateResidentRs update(
            @PathVariable UUID residentId,
            @RequestBody @Valid UpdateResidentRq updateResidentRq
    ) {
        return residentMapper.mapToUpdateRs(
                residentService.update(residentMapper.map(updateResidentRq), residentId)
        );
    }

    @PostMapping("/{residentId}/retire")
    public ReadResidentRs makeResidentPensioner(@PathVariable UUID residentId) {
        throw new UnsupportedOperationException();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{residentId}")
    public void delete(@PathVariable UUID residentId) {
        residentManagementService.delete(residentId);
    }
}
