package com.magicretro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.BoardEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.BoardRepo;

@Service
public class BoardService {

	@Autowired 
	BoardRepo boardRepo;

	public String addBoard(BoardEntity newBoard) {
		return Long.toString(boardRepo.save(newBoard).getId());
	}
	
	public BoardEntity getBoardById(String id) {
		return boardRepo.getBoardEntityById(Long.parseLong(id))
		.orElseThrow(()->new ResourceNotFoundException("Board " + id+ " not found"));
	}
	
	public String deleteBoardById(String id) {
		boardRepo.delete(getBoardById(id));
		return id;
	}
}
