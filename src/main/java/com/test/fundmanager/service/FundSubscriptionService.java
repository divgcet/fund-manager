package com.test.fundmanager.service;

import java.util.List;

import com.test.fundmanager.dto.FundSubscriptionDto;
import com.test.fundmanager.dto.SubscriptionVolumeByFund;
import com.test.fundmanager.dto.SubscriptionVolumeByInvester;

public interface FundSubscriptionService {
	
	public Long subscribeToFund(FundSubscriptionDto fundSubscriptionDto);
	public List<SubscriptionVolumeByFund> getSubscriptionVolumePerFund();
	public List<SubscriptionVolumeByInvester> getSubscriptionVolumePerInvester();
	
}
