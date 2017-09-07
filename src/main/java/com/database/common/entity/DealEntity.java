package com.database.common.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEAL_ENTITY")
public class DealEntity {
	@Id
	@SequenceGenerator(name="entitySequence", sequenceName="ENTITY_SEQUENCE", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator="entitySequence")
	@Column(name="DEAL_ID")
	private Long dealId;
	
	@Column(name="CLIENT_ID")
	private String clientId;
	
	@Column(name="PRINCIPAL")
	private BigDecimal principal;	
	
	@Column(name="DATE")
	private Date dealDate;
	
	//@ManyToMany(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	//@JoinTable(name= "DEAL_MAPPING", joinColumns={@JoinColumn(name="DEAL_ID")},inverseJoinColumns={@JoinColumn(name="JOIN_ROW")})
	//private List<DealEntity> entities;

	public DealEntity(){
		
	}
	
	public DealEntity(Long dealId, String clientId, BigDecimal principal,  Date dealDate) {
		super();
		this.dealId = dealId;
		this.clientId = clientId;
		this.principal = principal;	
		this.dealDate = dealDate;
	}

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public Date getDealDate() {
		return dealDate;
	}

	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}

	
	  
	 

}
