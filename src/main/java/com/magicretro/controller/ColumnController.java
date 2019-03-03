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

import com.magicretro.domain.ColumnEntity;
import com.magicretro.dto.ColumnDto;
import com.magicretro.mappers.ControllerMapper;
import com.magicretro.service.ColumnService;

@RestController
public class ColumnController {
	
	@Autowired
	ColumnService columnService;
	
	@Autowired
	ControllerMapper controllerMapper;
	
	@PostMapping("/columns")
	ResponseEntity<String> newColumn(@RequestBody ColumnEntity newColumn) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", columnService.addColumn(newColumn));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/boards/{id}/columns")
	public ResponseEntity<List<ColumnDto>> getBoardById(@PathVariable String id) {
		return new ResponseEntity<>(controllerMapper.toColumn(columnService.getColumnsByBoardId(id)), HttpStatus.OK);
	}
}
