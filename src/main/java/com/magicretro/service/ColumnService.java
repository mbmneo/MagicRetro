package com.magicretro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicretro.domain.ColumnEntity;
import com.magicretro.repository.ColumnRepo;

@Service
public class ColumnService {

	@Autowired 
	ColumnRepo columnRepo;

	public ColumnEntity addColumn(ColumnEntity newColumn) {
		return columnRepo.save(newColumn);
	}
}
