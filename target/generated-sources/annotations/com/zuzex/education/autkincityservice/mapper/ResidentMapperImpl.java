package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.dto.resident.CreateResidentRq;
import com.zuzex.education.autkincityservice.dto.resident.CreateResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.ReadResidentRs;
import com.zuzex.education.autkincityservice.dto.resident.ResidentDto;
import com.zuzex.education.autkincityservice.dto.resident.UpdateResidentRq;
import com.zuzex.education.autkincityservice.dto.resident.UpdateResidentRs;
import com.zuzex.education.autkincityservice.model.Resident;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-20T14:48:17+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class ResidentMapperImpl implements ResidentMapper {

    @Autowired
    private PassportMapper passportMapper;

    @Override
    public ResidentDto map(Resident source) {
        if ( source == null ) {
            return null;
        }

        ResidentDto.ResidentDtoBuilder residentDto = ResidentDto.builder();

        residentDto.id( source.getId() );
        residentDto.phone( source.getPhone() );
        residentDto.email( source.getEmail() );
        residentDto.passport( passportMapper.map( source.getPassport() ) );

        return residentDto.build();
    }

    @Override
    public Resident map(ResidentDto source) {
        if ( source == null ) {
            return null;
        }

        Resident.ResidentBuilder resident = Resident.builder();

        resident.id( source.id() );
        resident.email( source.email() );
        resident.passport( passportMapper.map( source.passport() ) );
        resident.phone( source.phone() );

        return resident.build();
    }

    @Override
    public ReadResidentRs mapToReadRs(Resident source) {
        if ( source == null ) {
            return null;
        }

        ReadResidentRs.ReadResidentRsBuilder readResidentRs = ReadResidentRs.builder();

        readResidentRs.id( source.getId() );
        readResidentRs.phone( source.getPhone() );
        readResidentRs.email( source.getEmail() );
        readResidentRs.passport( passportMapper.map( source.getPassport() ) );

        return readResidentRs.build();
    }

    @Override
    public Set<ResidentDto> map(Set<Resident> source) {
        if ( source == null ) {
            return null;
        }

        Set<ResidentDto> set = new LinkedHashSet<ResidentDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Resident resident : source ) {
            set.add( map( resident ) );
        }

        return set;
    }

    @Override
    public Resident map(CreateResidentRq source) {
        if ( source == null ) {
            return null;
        }

        Resident.ResidentBuilder resident = Resident.builder();

        resident.email( source.email() );
        resident.passport( passportMapper.map( source.passport() ) );
        resident.phone( source.phone() );

        return resident.build();
    }

    @Override
    public Resident map(UpdateResidentRq source) {
        if ( source == null ) {
            return null;
        }

        Resident.ResidentBuilder resident = Resident.builder();

        resident.email( source.email() );
        resident.phone( source.phone() );

        return resident.build();
    }

    @Override
    public CreateResidentRs mapToCreateRs(Resident source) {
        if ( source == null ) {
            return null;
        }

        CreateResidentRs.CreateResidentRsBuilder createResidentRs = CreateResidentRs.builder();

        createResidentRs.phone( source.getPhone() );
        createResidentRs.email( source.getEmail() );

        return createResidentRs.build();
    }

    @Override
    public UpdateResidentRs mapToUpdateRs(Resident source) {
        if ( source == null ) {
            return null;
        }

        UpdateResidentRs.UpdateResidentRsBuilder updateResidentRs = UpdateResidentRs.builder();

        updateResidentRs.phone( source.getPhone() );
        updateResidentRs.email( source.getEmail() );

        return updateResidentRs.build();
    }
}
