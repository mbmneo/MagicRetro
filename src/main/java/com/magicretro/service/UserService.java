package com.magicretro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.UserEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.UserRepo;

@Service
public class UserService extends BaseService<UserEntity> {
	
	@Autowired 
	UserRepo userRepo;
	
	/**
	 * Post User
	 * */
	public UserEntity postUser(UserEntity user) {
		return userRepo.save(user);
	}
	
	/**
	 * Patch User
	 * */
	public UserEntity patchUser(Long userId, UserEntity user) {
		UserEntity userEntity = getUser(userId);
		return userRepo.save(merge(user, userEntity));
	}
	
	
	/**
	 * Get One User by User ID
	 * */
	public UserEntity getUser(Long userId){
		return userRepo.getUserEntityById(userId).
		orElseThrow(()->new ResourceNotFoundException("User " + userId+ " not found"));
	}
}
