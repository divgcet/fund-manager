package com.test.fundmanager.domain;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
@Entity
@Table(name="FUND")
public class Fund {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "FUNDNAME")
	private String fundName;
	
	@Column
	private BigDecimal  minimumInvestmentAmount;
	
	Fund() {
			
	}

}
