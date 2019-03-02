package com.magicretro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.BoardEntity;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Long> {
		
	Optional<BoardEntity> getBoardEntityById(Long id);
}
