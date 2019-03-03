package com.magicretro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import com.magicretro.domain.BaseEntity;
import com.magicretro.mappers.ControllerMapper;

abstract public class BaseController<T extends BaseEntity<?>> {

	@Autowired
	ControllerMapper controllerMapper;
	
	protected HttpHeaders getHeaders(T entity){
		return getHeaders(entity.getId().toString());
	}
	
	protected HttpHeaders getHeaders(Long id){
		return getHeaders(Long.toString(id));
	}
	protected HttpHeaders getHeaders(String id){
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", id);
		return headers;
	}
}
