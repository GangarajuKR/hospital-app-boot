package com.ty.hospital.hospitalappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital.hospitalappboot.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
