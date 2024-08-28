package com.test.fundmanager.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FundDto {

	private String fundName;
	private BigDecimal  minimumInvestmentAmount;

}
