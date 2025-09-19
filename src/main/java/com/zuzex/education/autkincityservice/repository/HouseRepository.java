package com.zuzex.education.autkincityservice.repository;

import com.zuzex.education.autkincityservice.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HouseRepository extends JpaRepository<House, UUID> {
}
