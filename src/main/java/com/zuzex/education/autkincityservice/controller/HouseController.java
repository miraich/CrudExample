package com.zuzex.education.autkincityservice.controller;

import com.zuzex.education.autkincityservice.dto.house.CreateHouseRq;
import com.zuzex.education.autkincityservice.dto.house.CreateHouseRs;
import com.zuzex.education.autkincityservice.dto.house.GetAllHouseRs;
import com.zuzex.education.autkincityservice.dto.house.ReadHouseRs;
import com.zuzex.education.autkincityservice.dto.house.UpdateHouseRq;
import com.zuzex.education.autkincityservice.dto.house.UpdateHouseRs;
import com.zuzex.education.autkincityservice.mapper.HouseMapper;
import com.zuzex.education.autkincityservice.service.HouseManagementService;
import com.zuzex.education.autkincityservice.service.entity.HouseService;
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

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/houses")
@RequiredArgsConstructor
public class HouseController {
    private final HouseManagementService houseManagementService;
    private final HouseService houseService;
    private final HouseMapper houseMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CreateHouseRs create(@RequestBody @Valid CreateHouseRq createHouseRq) {
        return houseMapper.mapToCreateRs(houseManagementService.create(houseMapper.map(createHouseRq)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{houseId}/residents/{residentId}")
    public ReadHouseRs addOwner(
            @PathVariable UUID residentId,
            @PathVariable UUID houseId
    ) {
        return houseMapper.mapToReadHouseRs(houseManagementService.addOwner(residentId, houseId));
    }

    @GetMapping("/{houseId}")
    public ReadHouseRs get(@PathVariable UUID houseId) {
        return houseMapper.mapToReadHouseRs(houseService.get(houseId));
    }

    @GetMapping
    public GetAllHouseRs getAllHouseRs() {
        return GetAllHouseRs.builder().houses(houseMapper.map(houseService.getAll())).build();
    }

    @PatchMapping("/{houseId}")
    public UpdateHouseRs update(
            @PathVariable UUID houseId,
            @RequestBody @Valid UpdateHouseRq updateHouseRq
    ) {
        return houseMapper.mapToUpdateRs(houseManagementService.update(houseMapper.map(updateHouseRq), houseId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{houseId}")
    public void delete(@PathVariable UUID houseId) {
        houseManagementService.delete(houseId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{houseId}/residents/{residentId}")
    public void deleteOwner(
            @PathVariable UUID residentId,
            @PathVariable UUID houseId) {
        houseManagementService.deleteOwner(residentId, houseId);
    }
}
