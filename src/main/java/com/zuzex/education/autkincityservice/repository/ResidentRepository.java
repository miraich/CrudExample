package com.zuzex.education.autkincityservice.repository;

import com.zuzex.education.autkincityservice.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface ResidentRepository extends JpaRepository<Resident, UUID> {
    @Query("SELECT r FROM Resident r JOIN r.houses h WHERE h.address.street = :street")
    Set<Resident> getHouseOwnersByStreet(String street);

    @Query("""
            SELECT r from Resident r
            LEFT JOIN FETCH r.passport
            LEFT JOIN FETCH r.passport.address
            """)
    Set<Resident> getAllWithPassport();
}
