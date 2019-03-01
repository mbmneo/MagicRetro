package com.magicretro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.ItemEntity;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity, Long> {

}