package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.UserEntity;
import com.magicretro.dto.UserDto;
import com.magicretro.service.UserService;

@RestController
public class UserController extends BaseController<UserEntity> {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	ResponseEntity<String> postUser(@RequestBody UserDto user) {
		return new ResponseEntity<>(getHeaders(userService.postUser(controllerMapper.toUser(user))), HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
		return new ResponseEntity<>(controllerMapper.toUser(userService.getUser(userId)), HttpStatus.OK);
	}
}
