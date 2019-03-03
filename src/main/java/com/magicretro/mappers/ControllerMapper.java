package com.magicretro.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.magicretro.domain.BoardEntity;
import com.magicretro.domain.ColumnEntity;
import com.magicretro.domain.ItemEntity;
import com.magicretro.domain.UserEntity;
import com.magicretro.dto.BoardDto;
import com.magicretro.dto.ColumnDto;
import com.magicretro.dto.ItemDto;
import com.magicretro.dto.UserDto;

@Mapper
public interface ControllerMapper {
	
	@Mappings({})
	public BoardDto toBoard(BoardEntity board);
	
	@Mappings({})
	public BoardEntity toBoard(BoardDto board);
	
	@Mappings({
		@Mapping(expression = "java(column.getBoard().getId())", target = "boardId")
	})
	public ColumnDto toColumn(ColumnEntity column);
	
	@Mappings({
		@Mapping(source="boardId", target = "board.id")
	})
	public ColumnEntity toColumn(ColumnDto column);
	
	@Mappings({
		@Mapping(expression = "java(item.getColumn().getId())", target = "columnId")
	})
	public ItemDto toItem(ItemEntity item);
	
	@Mappings({
		@Mapping(source="columnId", target = "column.id")
	})
	public ItemEntity toItem(ItemDto item);
	
	@Mappings({})
	public UserEntity toUser(UserDto user);
	
	
	@Mappings({
		@Mapping(expression = "java(null)", target = "password")
	})
	public UserDto toUser(UserEntity user);
	
	
	public List<ColumnDto> toColumn(List<ColumnEntity> columns);
	
	public List<ItemDto> toItem(List<ItemEntity> items);
}