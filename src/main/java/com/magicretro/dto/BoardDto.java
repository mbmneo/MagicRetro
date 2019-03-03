package com.magicretro.dto;

import com.magicretro.enums.BoardStageCode;

import lombok.Data;

@Data
public class BoardDto {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private BoardStageCode stageCode;
	
}
