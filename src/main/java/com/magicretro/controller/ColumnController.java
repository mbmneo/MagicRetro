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

import com.magicretro.domain.ColumnEntity;
import com.magicretro.dto.ColumnDto;
import com.magicretro.service.ColumnService;

@RestController
public class ColumnController extends BaseController<ColumnEntity> {
	
	@Autowired
	ColumnService columnService;
	
	@PostMapping("/boards/{boardId}/columns")
	ResponseEntity<String> postColumn(@PathVariable Long boardId, @RequestBody ColumnEntity column) {
		return new ResponseEntity<>(getHeaders(columnService.postColumn(boardId, column)), HttpStatus.CREATED);
	}
	
	@PatchMapping("/boards/{boardId}/columns/{columnId}")
	ResponseEntity<String> patchColumn(@PathVariable Long boardId, @PathVariable Long columnId, @RequestBody ColumnEntity column) {
		return new ResponseEntity<>(getHeaders(columnService.patchColumn(boardId, columnId , column)), HttpStatus.OK);
	}
	
	@GetMapping("/boards/{boardId}/columns")
	public ResponseEntity<List<ColumnDto>> getColumnsByBoardId(@PathVariable Long boardId) {
		return new ResponseEntity<>(controllerMapper.toColumn(columnService.getColumns(boardId)), HttpStatus.OK);
	}
}
