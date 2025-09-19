package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.config.MapstructConfig;
import com.zuzex.education.autkincityservice.dto.address.AddressDto;
import com.zuzex.education.autkincityservice.model.Address;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface AddressMapper {
    Address map(AddressDto source);

    AddressDto map(Address address);
}
