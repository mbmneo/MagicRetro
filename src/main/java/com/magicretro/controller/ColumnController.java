package com.magicretro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.ColumnEntity;
import com.magicretro.service.ColumnService;

@RestController
public class ColumnController {
	
	@Autowired
	ColumnService columnService;
	
	@PostMapping("/columns")
	ColumnEntity newColumn(@RequestBody ColumnEntity newColumn) {
		return columnService.addColumn(newColumn);
	}
	
	@GetMapping("/boards/{id}/columns")
	public ResponseEntity<List<ColumnEntity>> getBoardById(@PathVariable String id) {
		return new ResponseEntity<>(columnService.getColumnsByBoardId(id), HttpStatus.OK);
	}
	
}
