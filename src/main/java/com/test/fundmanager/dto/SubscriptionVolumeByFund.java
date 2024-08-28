package com.test.fundmanager.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubscriptionVolumeByFund {
	
	private String fundName;

	private BigDecimal fundVolume;

}
