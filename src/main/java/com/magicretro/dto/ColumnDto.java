package com.magicretro.dto;

import com.magicretro.enums.ColorCode;

import lombok.Data;

@Data
public class ColumnDto {

	private Long id;

	private String title;

	private String description;

	private ColorCode colorCode;

}
