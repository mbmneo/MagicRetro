package com.magicretro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.ColumnEntity;
import com.magicretro.domain.ItemEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.ItemRepo;

@Service
public class ItemService extends BaseService<ItemEntity> {

	@Autowired 
	ItemRepo itemRepo;
	
	@Autowired 
	ColumnService columnService;

	/**
	 * Post Item
	 * */
	public ItemEntity postItem(Long columnId, ItemEntity item) {
		ColumnEntity column = columnService.getColumn(columnId);
		item.setColumn(column);
		return itemRepo.save(item);
	}
	
	/**
	 * Patch Item
	 * */
	public ItemEntity patchItem(Long columnId, Long itemId, ItemEntity item) {
		ColumnEntity columnEntity = columnService.getColumn(columnId);
		ItemEntity itemEntity = getItem(itemId);
		item.setColumn(columnEntity);
		return itemRepo.save(merge(item, itemEntity));
	}
	
	/**
	 * Get One Item  by Column ID And Item ID
	 * */
	private ItemEntity getItem(Long itemId){
		return itemRepo.getItemEntityById(itemId).
		orElseThrow(()->new ResourceNotFoundException("Item " + itemId+ " not found"));
	}
	
	/**
	 * Get All Items by Column ID
	 * */
	public List<ItemEntity> getItems(Long columnId){
		ColumnEntity column = columnService.getColumn(columnId);
		return itemRepo.getItemEntityByColumnId(column.getId()).
		orElseThrow(()->new ResourceNotFoundException("No items linked to column "+ columnId));
	}
}