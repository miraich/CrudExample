package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.config.MapstructConfig;
import com.zuzex.education.autkincityservice.dto.passport.PassportDto;
import com.zuzex.education.autkincityservice.model.Passport;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(config = MapstructConfig.class, uses = AddressMapper.class)
public interface PassportMapper {
    Passport map(PassportDto source);

    PassportDto map(Passport source);

    Set<PassportDto> map(Set<Passport> source);
}
