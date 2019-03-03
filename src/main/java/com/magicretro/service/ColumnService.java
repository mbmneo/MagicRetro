package com.magicretro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.BoardEntity;
import com.magicretro.domain.ColumnEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.ColumnRepo;

@Service
public class ColumnService extends BaseService<ColumnEntity> {

	@Autowired 
	ColumnRepo columnRepo;

	@Autowired 
	BoardService boardService;
	
	/**
	 * Post Column
	 * */
	public String postColumn(Long boardId, ColumnEntity column) {
		BoardEntity boardEntity = boardService.getBoard(boardId);
		column.setBoard(boardEntity);
		return Long.toString(columnRepo.save(column).getId());
	}
	
	/**
	 * Patch Column
	 * */
	public String patchColumn(Long boardId, Long columnId, ColumnEntity column) {
		BoardEntity boardEntity = boardService.getBoard(boardId);
		ColumnEntity columnEntity = getColumn(columnId);
		column.setBoard(boardEntity);
		return Long.toString(columnRepo.save(merge(column, columnEntity)).getId());
	}
	
	/**
	 * Get One Column  by Board ID And Column ID
	 * */
	public ColumnEntity getColumn(Long columnId) {
		return columnRepo.getColumnEntityById(columnId)
		.orElseThrow(()->new ResourceNotFoundException("Column " + columnId+ " not found"));
	}
	
	/**
	 * Get All Columns by Board ID
	 * */
	public List<ColumnEntity> getColumns(Long boardId) {
		BoardEntity board = boardService.getBoard(boardId);
		return columnRepo.getColumnEntityByBoardId(board.getId()).
		orElseThrow(()->new ResourceNotFoundException("No columns linked to board "+ boardId));
	}
}