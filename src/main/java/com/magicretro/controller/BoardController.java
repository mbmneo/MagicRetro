package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.BoardEntity;
import com.magicretro.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/boards")
	ResponseEntity<String>  newBoard(@RequestBody BoardEntity newBoard) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", boardService.addBoard(newBoard));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/boards/{id}")
	public ResponseEntity<BoardEntity> getBoardById(@PathVariable String id) {
		return new ResponseEntity<>(boardService.getBoardById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/boards/{id}")
	public ResponseEntity<String> deleteBoardById(@PathVariable String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", boardService.deleteBoardById(id));
		return new ResponseEntity<>(headers, HttpStatus.OK	);
	}
	
}
