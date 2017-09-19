package com.database.common.specification;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

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
public class EqualsFilter<E> implements Specification<E> {

	private final LocalDate start;
	private final LocalDate end;
	private final String field;

	public EqualsFilter(final LocalDate start, final LocalDate end, final String field) {
		this.start = start;
		this.end = end;
		this.field = field;
	}

	public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		return builder.between(builder.function("FUNC", Date.class, root.<Date>get(field)),
				Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant()),
				Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant()));
	}

}
