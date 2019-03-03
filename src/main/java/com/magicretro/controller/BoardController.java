package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.BoardEntity;
import com.magicretro.dto.BoardDto;
import com.magicretro.mappers.ControllerMapper;
import com.magicretro.service.BoardService;

@RestController
public class BoardController extends BaseController<BoardEntity> {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ControllerMapper controllerMapper;
	
	@PostMapping("/boards")
	ResponseEntity<String>  postBoard(@RequestBody BoardDto board) {
		return new ResponseEntity<>(getHeaders(boardService.postBoard(controllerMapper.toBoard(board))), HttpStatus.CREATED);
	}

	@PatchMapping("/boards/{boardId}")
	public ResponseEntity<String> patchBoard(@PathVariable Long boardId, @RequestBody BoardDto board) {
		return new ResponseEntity<>(getHeaders(boardService.patchBoard(boardId, controllerMapper.toBoard(board))), HttpStatus.CREATED);
	}
	
	@GetMapping("/boards/{boardId}")
	public ResponseEntity<BoardDto> getBoard(@PathVariable Long boardId) {
		return new ResponseEntity<>(controllerMapper.toBoard(boardService.getBoard(boardId)), HttpStatus.OK);
	}
	
	@DeleteMapping("/boards/{boardId}")
	public ResponseEntity<String> deleteBoard(@PathVariable Long boardId) {
		return new ResponseEntity<>(getHeaders(boardService.deleteBoard(boardId)), HttpStatus.OK);
	}	
}
