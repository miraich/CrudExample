package com.zuzex.education.autkincityservice.mapper;

import com.zuzex.education.autkincityservice.dto.car.CarDto;
import com.zuzex.education.autkincityservice.dto.car.CreateCarRq;
import com.zuzex.education.autkincityservice.dto.car.CreateCarRs;
import com.zuzex.education.autkincityservice.dto.car.ReadCarRs;
import com.zuzex.education.autkincityservice.dto.car.UpdateCarRq;
import com.zuzex.education.autkincityservice.dto.car.UpdateCarRs;
import com.zuzex.education.autkincityservice.model.Car;
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
public class CarMapperImpl implements CarMapper {

    @Autowired
    private ResidentMapper residentMapper;

    @Override
    public ReadCarRs mapToReadCarRs(Car source) {
        if ( source == null ) {
            return null;
        }

        ReadCarRs.ReadCarRsBuilder readCarRs = ReadCarRs.builder();

        readCarRs.resident( residentMapper.map( source.getResident() ) );
        readCarRs.brand( source.getBrand() );
        readCarRs.color( source.getColor() );
        readCarRs.price( source.getPrice() );

        return readCarRs.build();
    }

    @Override
    public CarDto map(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto.CarDtoBuilder carDto = CarDto.builder();

        carDto.color( car.getColor() );
        carDto.brand( car.getBrand() );
        carDto.price( car.getPrice() );
        carDto.resident( residentMapper.map( car.getResident() ) );

        return carDto.build();
    }

    @Override
    public Set<CarDto> map(Set<Car> source) {
        if ( source == null ) {
            return null;
        }

        Set<CarDto> set = new LinkedHashSet<CarDto>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );
        for ( Car car : source ) {
            set.add( map( car ) );
        }

        return set;
    }

    @Override
    public Car map(CreateCarRq source) {
        if ( source == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.brand( source.brand() );
        car.color( source.color() );
        car.price( source.price() );

        return car.build();
    }

    @Override
    public Car map(UpdateCarRq source) {
        if ( source == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.brand( source.brand() );
        car.color( source.color() );
        car.price( source.price() );

        return car.build();
    }

    @Override
    public CreateCarRs mapToCreateRs(Car source) {
        if ( source == null ) {
            return null;
        }

        CreateCarRs.CreateCarRsBuilder createCarRs = CreateCarRs.builder();

        createCarRs.color( source.getColor() );
        createCarRs.brand( source.getBrand() );
        createCarRs.price( source.getPrice() );

        return createCarRs.build();
    }

    @Override
    public UpdateCarRs mapToUpdateRs(Car source) {
        if ( source == null ) {
            return null;
        }

        UpdateCarRs.UpdateCarRsBuilder updateCarRs = UpdateCarRs.builder();

        updateCarRs.color( source.getColor() );
        updateCarRs.brand( source.getBrand() );
        updateCarRs.price( source.getPrice() );

        return updateCarRs.build();
    }
}
