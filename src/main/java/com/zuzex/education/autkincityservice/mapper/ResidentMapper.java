package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.config.MapstructConfig;
import com.zuzex.education.autkincityservice.dto.resident.CreateResidentRq;
import com.zuzex.education.autkincityservice.dto.resident.CreateResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.ReadResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.ResidentDto;
import com.zuzex.education.autkincityservice.dto.resident.UpdateResidentRq;
import com.zuzex.education.autkincityservice.dto.resident.UpdateResidentRs;
import com.zuzex.education.autkincityservice.model.Resident;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(config = MapstructConfig.class, uses = {AddressMapper.class, PassportMapper.class})
public interface ResidentMapper {
    ResidentDto map(Resident source);

    @Mapping(target = "cars", ignore = true)
    @Mapping(target = "houses", ignore = true)
    Resident map(ResidentDto source);

    ReadResidentRs mapToReadRs(Resident source);

    Set<ResidentDto> map(Set<Resident> source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cars", ignore = true)
    @Mapping(target = "houses", ignore = true)
    Resident map(CreateResidentRq source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "passport", ignore = true)
    @Mapping(target = "cars", ignore = true)
    @Mapping(target = "houses", ignore = true)
    Resident map(UpdateResidentRq source);

    CreateResidentRs mapToCreateRs(Resident source);

    UpdateResidentRs mapToUpdateRs(Resident source);
}
