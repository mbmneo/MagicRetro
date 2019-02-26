package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicretro.domain.Board;
import com.magicretro.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping("/board")
	Board newBoard(@RequestBody Board newBoard) {
		return boardService.addBoard(newBoard);
	}
	
}
