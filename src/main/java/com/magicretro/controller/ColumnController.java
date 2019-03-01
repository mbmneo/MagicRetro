package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.ColumnEntity;
import com.magicretro.service.ColumnService;

@RestController
public class ColumnController {
	
	@Autowired
	ColumnService columnService;
	
	@PostMapping("/column")
	ColumnEntity newBoard(@RequestBody ColumnEntity newColumn) {
		return columnService.addColumn(newColumn);
	}
}
