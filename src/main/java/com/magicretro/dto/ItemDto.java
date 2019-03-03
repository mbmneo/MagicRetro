package com.magicretro.dto;

import lombok.Data;

@Data
public class ItemDto {

	private Long id;
	
	private String description;
	
	private Integer totalVote;
	
	private Long columnId;
}
