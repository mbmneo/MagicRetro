package com.magicretro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.ItemEntity;
import com.magicretro.dto.ItemDto;
import com.magicretro.mappers.ControllerMapper;
import com.magicretro.service.ItemService;

@RestController
public class ItemController extends BaseController<ItemEntity> {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ControllerMapper controllerMapper;
	
	@PostMapping("/columns/{columnId}/items")
	ResponseEntity<String> postItem(@PathVariable Long columnId, @RequestBody ItemDto item) {
		return new ResponseEntity<>(getHeaders(itemService.postItem(columnId, controllerMapper.toItem(item))), HttpStatus.CREATED);
	}
	
	@PatchMapping("/columns/{columnId}/items/{itemId}")
	ResponseEntity<String> patchColumn(@PathVariable Long columnId, @PathVariable Long itemId, @RequestBody ItemDto item) {
		return new ResponseEntity<>(getHeaders(itemService.patchItem(columnId, itemId , controllerMapper.toItem(item))), HttpStatus.CREATED);
	}
	
	@GetMapping("/columns/{columnId}/items")
	public ResponseEntity<List<ItemDto>> getBoardById(@PathVariable Long columnId) {
		return new ResponseEntity<>(controllerMapper.toItem(itemService.getItems(columnId)), HttpStatus.OK);
	}
}
