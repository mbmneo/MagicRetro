package com.magicretro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.BoardEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.BoardRepo;

@Service
public class BoardService extends BaseService<BoardEntity> {

	@Autowired 
	BoardRepo boardRepo;

	/**
	 * Post Board
	 * */
	public String postBoard(BoardEntity board) {
		return Long.toString(boardRepo.save(board).getId());
	}
	
	/**
	 * Patch Board
	 * */
	public String patchBoard(Long boardId, BoardEntity board) {
		BoardEntity boardEntity = getBoard(boardId);
		return Long.toString(boardRepo.save(merge(board, boardEntity)).getId());
	}
	
	/**
	 * Get One Board By Board ID
	 * */
	public BoardEntity getBoard(Long boardId) {
		return boardRepo.getBoardEntityById(boardId)
		.orElseThrow(()->new ResourceNotFoundException("Board " + boardId+ " not found"));
	}
	
	/**
	 * Delete Board By Board ID
	 * */
	public Long deleteBoard(Long boardId) {
		boardRepo.deleteById(boardId);
		return boardId;
	}
}