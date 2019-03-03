package com.magicretro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.ColumnEntity;
import com.magicretro.domain.ItemEntity;
import com.magicretro.exceptions.ResourceNotFoundException;
import com.magicretro.repository.ItemRepo;

@Service
public class ItemService {

	@Autowired 
	ItemRepo itemRepo;
	
	@Autowired 
	ColumnService columnService;

	public String addItem(ItemEntity newItem) {
		return Long.toString(itemRepo.save(newItem).getId());
	}
	
	public List<ItemEntity> getItemsByColumnId(String id){
		ColumnEntity column = columnService.getColumnEntityById(id);
		return itemRepo.getItemEntityByColumnId(column.getId()).
		orElseThrow(()->new ResourceNotFoundException("No items linked to column "+ id));
	}
}
