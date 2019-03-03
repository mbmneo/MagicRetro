package com.magicretro.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import com.magicretro.domain.BoardEntity;
import com.magicretro.domain.ColumnEntity;
import com.magicretro.domain.ItemEntity;
import com.magicretro.dto.BoardDto;
import com.magicretro.dto.ColumnDto;
import com.magicretro.dto.ItemDto;

@Mapper
public interface ControllerMapper {
	
	@Mappings({})
	public BoardDto toBoard(BoardEntity board);
	
	@Mappings({})
	public BoardEntity toBoard(BoardDto board);
	
	@Mappings({})
	public ColumnDto toColumn(ColumnEntity column);
	
	@Mappings({})
	public ColumnEntity toColumn(ColumnDto column);
	
	@Mappings({})
	public ItemDto toItem(ItemEntity item);
	
	@Mappings({})
	public ItemEntity toItem(ItemDto item);
	
	public default List<ColumnDto> toColumn(List<ColumnEntity> columns) {
		if ( columns == null ) {
            return null;
        }
		return columns.stream().map(col->toColumn(col)).collect(Collectors.toList());
	}
	
	public default List<ItemDto> toItem(List<ItemEntity> items) {
		if ( items == null ) {
            return null;
        }
		return items.stream().map(item->toItem(item)).collect(Collectors.toList());
	}
}