package com.zuzex.education.autkincityservice.repository;

import com.zuzex.education.autkincityservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query("""
            SELECT c from Car c
            JOIN FETCH c.resident
            LEFT JOIN FETCH c.resident.passport
            LEFT JOIN FETCH c.resident.passport.address
            WHERE c.resident.id = :residentId
            """)
    Set<Car> getCarsByResidentId(UUID residentId);
}
