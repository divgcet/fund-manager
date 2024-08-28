package com.test.fundmanager.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubscriptionVolumeByInvester {
	private String investerName;
	private BigDecimal fundVolume;
}
