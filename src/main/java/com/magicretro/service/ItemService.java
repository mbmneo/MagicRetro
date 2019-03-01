package com.magicretro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.ItemEntity;
import com.magicretro.repository.ItemRepo;

@Service
public class ItemService {

	@Autowired 
	ItemRepo itemRepo;

	public ItemEntity addItem(ItemEntity newItem) {
		return itemRepo.save(newItem);
	}
}
