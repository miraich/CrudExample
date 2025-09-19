package com.zuzex.education.autkincityservice.repository;

import com.zuzex.education.autkincityservice.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;
import java.util.UUID;

public interface PassportRepository extends JpaRepository<Passport, UUID> {
    @Query(value = "SELECT * FROM passport WHERE gender = :gender AND last_name LIKE CONCAT(:letter, '%')",
            nativeQuery = true)
    Set<Passport> getPassportsBySurnameLetter(String gender, Character letter);
}
