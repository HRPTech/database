package com.database.common.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

/**
 * Specification is used to query the database
 * 
 * @author hiran
 *
 * @param <E>
 */
public class DateBetweenFilter<E> implements Specification<E> {

	private final Object value;
	private final String field;

	public DateBetweenFilter(final Object value, final String field) {
		this.value = value;
		this.field = field;
	}

	public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		return builder.equal(root.get(field), value);
	}

}
