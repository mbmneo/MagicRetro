package com.magicretro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magicretro.domain.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
		
	Optional<UserEntity> getUserEntityById(Long id);
}
