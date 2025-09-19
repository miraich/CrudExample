package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.config.MapstructConfig;
import com.zuzex.education.autkincityservice.dto.house.CreateHouseRq;
import com.zuzex.education.autkincityservice.dto.house.CreateHouseRs;
import com.zuzex.education.autkincityservice.dto.house.HouseDto;
import com.zuzex.education.autkincityservice.dto.house.ReadHouseRs;
import com.zuzex.education.autkincityservice.dto.house.UpdateHouseRq;
import com.zuzex.education.autkincityservice.dto.house.UpdateHouseRs;
import com.zuzex.education.autkincityservice.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(config = MapstructConfig.class, uses = {AddressMapper.class, PassportMapper.class})
public interface HouseMapper {
    ReadHouseRs mapToReadHouseRs(House source);

    Set<HouseDto> map(Set<House> source);

    @Mapping(target = "address.id", source = "addressId")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "residents", ignore = true)
    House map(CreateHouseRq source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "residents", ignore = true)
    @Mapping(target = "address.id", source = "addressId")
    House map(UpdateHouseRq source);

    @Mapping(target = "addressId", source = "address.id")
    CreateHouseRs mapToCreateRs(House source);

    @Mapping(target = "addressId", source = "address.id")
    UpdateHouseRs mapToUpdateRs(House source);
}
