package com.magicretro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.BoardEntity;
import com.magicretro.repository.BoardRepo;

@Service
public class BoardService {

	@Autowired 
	BoardRepo boardRepo;

	public BoardEntity addBoard(BoardEntity newBoard) {
		return boardRepo.save(newBoard);
	}
}
