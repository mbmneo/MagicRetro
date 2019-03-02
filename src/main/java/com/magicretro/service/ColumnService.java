package com.magicretro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.BoardEntity;
import com.magicretro.domain.ColumnEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.ColumnRepo;

@Service
public class ColumnService {

	@Autowired 
	BoardService boardService;
	
	@Autowired 
	ColumnRepo columnRepo;
	
	public ColumnEntity addColumn(ColumnEntity newColumn) {
		return columnRepo.save(newColumn);
	}
	
	public List<ColumnEntity> getColumnsByBoardId(String id) {
		BoardEntity board = boardService.getBoardById(id);
		return columnRepo.getColumnEntityByBoardId(board.getId()).
		orElseThrow(()->new ResourceNotFoundException("No columns linked to board "+ id));
	}
}