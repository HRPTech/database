package com.database.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.database.common.entity.DealEntity;

@Repository
public interface DealRepository extends CrudRepository<DealEntity, Long>, JpaSpecificationExecutor<DealEntity> {

	List<DealEntity> findAllByDealId(Long id);
}
