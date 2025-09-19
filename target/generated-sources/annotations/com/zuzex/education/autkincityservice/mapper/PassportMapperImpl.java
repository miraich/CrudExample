package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.dto.passport.PassportDto;
import com.zuzex.education.autkincityservice.model.Passport;
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
public class PassportMapperImpl implements PassportMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Passport map(PassportDto source) {
        if ( source == null ) {
            return null;
        }

        Passport.PassportBuilder passport = Passport.builder();

        passport.id( source.id() );
        passport.gender( source.gender() );
        passport.address( addressMapper.map( source.address() ) );
        passport.firstName( source.firstName() );
        passport.lastName( source.lastName() );
        passport.birthDate( source.birthDate() );

        return passport.build();
    }

    @Override
    public PassportDto map(Passport source) {
        if ( source == null ) {
            return null;
        }

        PassportDto.PassportDtoBuilder passportDto = PassportDto.builder();

        passportDto.id( source.getId() );
        passportDto.gender( source.getGender() );
        passportDto.address( addressMapper.map( source.getAddress() ) );
        passportDto.birthDate( source.getBirthDate() );
        passportDto.firstName( source.getFirstName() );
        passportDto.lastName( source.getLastName() );

        return passportDto.build();
    }

    @Override
    public Set<PassportDto> map(Set<Passport> source) {
        if ( source == null ) {
            return null;
        }

        Set<PassportDto> set = new LinkedHashSet<PassportDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Passport passport : source ) {
            set.add( map( passport ) );
        }

        return set;
    }
}
