package com.database.common.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
/**
 * Specification is used to query the database
 * @author hiran
 *
 * @param <E>
 */
public class DealSpecification<E> implements Specification<E> {

	private Long id;

	public void setId(Long id) {
		this.id = id;
	}

	public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		return root.<Long>get("dealId").in(id);
	}

}
