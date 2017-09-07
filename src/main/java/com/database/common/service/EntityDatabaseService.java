package com.database.common.service;

import org.springframework.data.domain.Page;

import com.database.common.entity.DealEntity;

public interface EntityDatabaseService {

	Page<DealEntity> getData(Long id);
	
}
