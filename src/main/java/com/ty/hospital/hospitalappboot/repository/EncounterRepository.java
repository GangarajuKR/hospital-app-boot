package com.ty.hospital.hospitalappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer> {

}
