package com.magicretro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.ItemEntity;

@Repository
public interface ItemRepo extends JpaRepository<ItemEntity, Long> {
	
	Optional<List<ItemEntity>> getItemEntityByColumnId(Long id);
}
