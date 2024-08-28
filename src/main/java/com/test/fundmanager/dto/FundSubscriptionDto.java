package com.test.fundmanager.dto;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Data;
@Data
public class FundSubscriptionDto {
	
	private UUID fundId;

	private UUID investorId;
	
	private BigDecimal investedAmount;
	
}
