package com.magicretro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.BoardEntity;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Long> {

	
	
}
