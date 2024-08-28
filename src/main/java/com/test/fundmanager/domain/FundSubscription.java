package com.test.fundmanager.domain;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Builder
@Table(name="FUNDSUBSCRIPTION")
public class FundSubscription {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="FUNDID")
	private UUID fundId;
	
	@Column(name="INVESTORID")
	private UUID investorId;
	
	@Column(name="INVESTEDAMOUNT")
	private BigDecimal investedAmount;
	
}
