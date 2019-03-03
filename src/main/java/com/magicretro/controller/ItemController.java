package com.magicretro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.ItemEntity;
import com.magicretro.dto.ItemDto;
import com.magicretro.mappers.ControllerMapper;
import com.magicretro.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ControllerMapper controllerMapper;
	
	@PostMapping("/items")
	ResponseEntity<String> newItem(@RequestBody ItemEntity newItem) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", itemService.addItem(newItem));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/columns/{id}/items")
	public ResponseEntity<List<ItemDto>> getBoardById(@PathVariable String id) {
		return new ResponseEntity<>(controllerMapper.toItem(itemService.getItemsByColumnId(id)), HttpStatus.OK);
	}
}
