package com.database.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.database.common.entity.DealEntity;
import com.database.common.repository.DealRepository;
import com.database.common.specification.DealSpecification;


@Service
public class EntityDatabaseServiceImpl implements EntityDatabaseService {

	private DealRepository repo;
	
	@Autowired
	public EntityDatabaseServiceImpl(final DealRepository repo) {
		this.repo = repo;
	}
	
	public EntityDatabaseServiceImpl(){
		
	}

	public Page<DealEntity> getData(Long id) {

		DealSpecification<DealEntity> dealSpec = new DealSpecification<>();
		dealSpec.setId(id);

		Specifications<DealEntity> specs = Specifications.<DealEntity>where(dealSpec);
		Page<DealEntity> deals = repo.findAll(specs, new PageRequest(0, 100));
		return deals;
	}
	
	public Long addDeal(DealEntity deal){
		return repo.save(deal).getDealId();		
	}
	
	
}
