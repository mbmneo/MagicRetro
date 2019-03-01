package com.magicretro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.ColumnEntity;

@Repository
public interface ColumnRepo extends JpaRepository<ColumnEntity, Long> {

}
