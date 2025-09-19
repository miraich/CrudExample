package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.config.MapstructConfig;
import com.zuzex.education.autkincityservice.dto.car.CarDto;
import com.zuzex.education.autkincityservice.dto.car.CreateCarRq;
import com.zuzex.education.autkincityservice.dto.car.CreateCarRs;
import com.zuzex.education.autkincityservice.dto.car.ReadCarRs;
import com.zuzex.education.autkincityservice.dto.car.UpdateCarRq;
import com.zuzex.education.autkincityservice.dto.car.UpdateCarRs;
import com.zuzex.education.autkincityservice.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(config = MapstructConfig.class, uses = {AddressMapper.class, PassportMapper.class, ResidentMapper.class})
public interface CarMapper {
    ReadCarRs mapToReadCarRs(Car source);

    CarDto map(Car car);

    Set<CarDto> map(Set<Car> source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resident", ignore = true)
    Car map(CreateCarRq source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "resident", ignore = true)
    Car map(UpdateCarRq source);

    CreateCarRs mapToCreateRs(Car source);

    UpdateCarRs mapToUpdateRs(Car source);
}
