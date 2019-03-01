package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.ItemEntity;
import com.magicretro.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/item")
	ItemEntity newItem(@RequestBody ItemEntity newItem) {
		return itemService.addItem(newItem);
	}
}
