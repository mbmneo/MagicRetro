package com.magicretro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.ColumnEntity;

@Repository
public interface ColumnRepo extends JpaRepository<ColumnEntity, Long> {

	Optional<ColumnEntity> getColumnEntityById(Long id);
	Optional<List<ColumnEntity>> getColumnEntityByBoardId(Long id);
}
