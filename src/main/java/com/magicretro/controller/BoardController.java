package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.dto.BoardDto;
import com.magicretro.mappers.ControllerMapper;
import com.magicretro.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ControllerMapper controllerMapper;
	
	
	@PostMapping("/boards")
	ResponseEntity<String>  postBoard(@RequestBody BoardDto board) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", boardService.postBoard(controllerMapper.toBoard(board)));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PatchMapping("/boards/{boardId}")
	public ResponseEntity<String> patchBoard(@PathVariable Long boardId, @RequestBody BoardDto board) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", boardService.patchBoard(boardId, controllerMapper.toBoard(board)));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/boards/{boardId}")
	public ResponseEntity<BoardDto> getBoard(@PathVariable Long boardId) {
		return new ResponseEntity<>(controllerMapper.toBoard(boardService.getBoard(boardId)), HttpStatus.OK);
	}
	
	@DeleteMapping("/boards/{boardId}")
	public ResponseEntity<String> deleteBoard(@PathVariable Long boardId) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", Long.toString(boardService.deleteBoard(boardId)));
		return new ResponseEntity<>(headers, HttpStatus.OK);
	}	
}
