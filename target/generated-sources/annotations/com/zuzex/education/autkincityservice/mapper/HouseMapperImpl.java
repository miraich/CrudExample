package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.dto.house.CreateHouseRq;
import com.zuzex.education.autkincityservice.dto.house.CreateHouseRs;
import com.zuzex.education.autkincityservice.dto.house.HouseDto;
import com.zuzex.education.autkincityservice.dto.house.ReadHouseRs;
import com.zuzex.education.autkincityservice.dto.house.UpdateHouseRq;
import com.zuzex.education.autkincityservice.dto.house.UpdateHouseRs;
import com.zuzex.education.autkincityservice.dto.resident.ResidentDto;
import com.zuzex.education.autkincityservice.model.Address;
import com.zuzex.education.autkincityservice.model.House;
import com.zuzex.education.autkincityservice.model.Resident;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T14:48:17+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class HouseMapperImpl implements HouseMapper {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private PassportMapper passportMapper;

    @Override
    public ReadHouseRs mapToReadHouseRs(House source) {
        if ( source == null ) {
            return null;
        }

        ReadHouseRs.ReadHouseRsBuilder readHouseRs = ReadHouseRs.builder();

        readHouseRs.address( addressMapper.map( source.getAddress() ) );
        readHouseRs.residents( residentSetToResidentDtoSet( source.getResidents() ) );
        readHouseRs.price( source.getPrice() );

        return readHouseRs.build();
    }

    @Override
    public Set<HouseDto> map(Set<House> source) {
        if ( source == null ) {
            return null;
        }

        Set<HouseDto> set = new LinkedHashSet<HouseDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( House house : source ) {
            set.add( houseToHouseDto( house ) );
        }

        return set;
    }

    @Override
    public House map(CreateHouseRq source) {
        if ( source == null ) {
            return null;
        }

        House.HouseBuilder house = House.builder();

        house.address( createHouseRqToAddress( source ) );
        house.price( source.price() );

        return house.build();
    }

    @Override
    public House map(UpdateHouseRq source) {
        if ( source == null ) {
            return null;
        }

        House.HouseBuilder house = House.builder();

        house.address( updateHouseRqToAddress( source ) );
        house.price( source.price() );

        return house.build();
    }

    @Override
    public CreateHouseRs mapToCreateRs(House source) {
        if ( source == null ) {
            return null;
        }

        CreateHouseRs.CreateHouseRsBuilder createHouseRs = CreateHouseRs.builder();

        createHouseRs.addressId( sourceAddressId( source ) );
        createHouseRs.price( source.getPrice() );

        return createHouseRs.build();
    }

    @Override
    public UpdateHouseRs mapToUpdateRs(House source) {
        if ( source == null ) {
            return null;
        }

        UpdateHouseRs.UpdateHouseRsBuilder updateHouseRs = UpdateHouseRs.builder();

        updateHouseRs.addressId( sourceAddressId( source ) );
        updateHouseRs.price( source.getPrice() );

        return updateHouseRs.build();
    }

    protected ResidentDto residentToResidentDto(Resident resident) {
        if ( resident == null ) {
            return null;
        }

        ResidentDto.ResidentDtoBuilder residentDto = ResidentDto.builder();

        residentDto.id( resident.getId() );
        residentDto.phone( resident.getPhone() );
        residentDto.email( resident.getEmail() );
        residentDto.passport( passportMapper.map( resident.getPassport() ) );

        return residentDto.build();
    }

    protected Set<ResidentDto> residentSetToResidentDtoSet(Set<Resident> set) {
        if ( set == null ) {
            return null;
        }

        Set<ResidentDto> set1 = new LinkedHashSet<ResidentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Resident resident : set ) {
            set1.add( residentToResidentDto( resident ) );
        }

        return set1;
    }

    protected HouseDto houseToHouseDto(House house) {
        if ( house == null ) {
            return null;
        }

        HouseDto.HouseDtoBuilder houseDto = HouseDto.builder();

        houseDto.id( house.getId() );
        houseDto.address( addressMapper.map( house.getAddress() ) );
        houseDto.price( house.getPrice() );

        return houseDto.build();
    }

    protected Address createHouseRqToAddress(CreateHouseRq createHouseRq) {
        if ( createHouseRq == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( createHouseRq.addressId() );

        return address.build();
    }

    protected Address updateHouseRqToAddress(UpdateHouseRq updateHouseRq) {
        if ( updateHouseRq == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( updateHouseRq.addressId() );

        return address.build();
    }

    private UUID sourceAddressId(House house) {
        Address address = house.getAddress();
        if ( address == null ) {
            return null;
        }
        return address.getId();
    }
}
