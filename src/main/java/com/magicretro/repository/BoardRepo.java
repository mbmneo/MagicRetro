package com.magicretro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.Board;

@Repository
public interface BoardRepo extends JpaRepository<Board, Long> {

	
	
}
