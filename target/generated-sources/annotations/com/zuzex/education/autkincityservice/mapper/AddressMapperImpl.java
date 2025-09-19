package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.dto.address.AddressDto;
import com.zuzex.education.autkincityservice.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T14:48:17+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address map(AddressDto source) {
        if ( source == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( source.id() );
        address.country( source.country() );
        address.city( source.city() );
        address.street( source.street() );
        address.house( source.house() );

        return address.build();
    }

    @Override
    public AddressDto map(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto.AddressDtoBuilder addressDto = AddressDto.builder();

        addressDto.id( address.getId() );
        addressDto.country( address.getCountry() );
        addressDto.city( address.getCity() );
        addressDto.street( address.getStreet() );
        addressDto.house( address.getHouse() );

        return addressDto.build();
    }
}
