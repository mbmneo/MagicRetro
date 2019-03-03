package com.magicretro.service;

import org.springframework.beans.BeanUtils;

import com.magicretro.domain.BaseEntity;

abstract public class BaseService<T extends BaseEntity<?>> {

	/**
	 * Merge source into target but ignore id and activeIndicator
	 * */
	public T merge(T source, T target) {
		BeanUtils.copyProperties(source, target, "id", "activeIndicator");
		return target;
	}
}
