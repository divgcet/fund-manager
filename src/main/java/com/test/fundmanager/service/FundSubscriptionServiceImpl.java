package com.test.fundmanager.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.fundmanager.domain.Fund;
import com.test.fundmanager.domain.FundSubscription;
import com.test.fundmanager.dto.FundSubscriptionDto;
import com.test.fundmanager.dto.SubscriptionVolumeByFund;
import com.test.fundmanager.dto.SubscriptionVolumeByInvester;
import com.test.fundmanager.exception.MinimumAmountValidationException;
import com.test.fundmanager.jpa.FundRepository;
import com.test.fundmanager.jpa.FundSubscriptionRepository;

@Service
public class FundSubscriptionServiceImpl implements FundSubscriptionService {

	@Autowired
	private FundSubscriptionRepository fundSubscriptionRepository;
	
	@Autowired
	private FundRepository fundRepository;
	
	@Override
	public Long subscribeToFund(FundSubscriptionDto fundSubscriptionDto) {
		
		Optional<Fund> fundOptional = fundRepository.findById(fundSubscriptionDto.getFundId());
		Fund fundObject =fundOptional.orElseThrow(RuntimeException::new);
		Integer residual = fundSubscriptionDto.getInvestedAmount().compareTo(fundObject.getMinimumInvestmentAmount());
		if(residual < 0) {
			throw new MinimumAmountValidationException(fundObject.getMinimumInvestmentAmount());
		}
		
		FundSubscription fundSubscriptionObj = null;
		FundSubscription fundSubscription = FundSubscription.builder()
													.fundId(fundSubscriptionDto.getFundId())
													.investedAmount(fundSubscriptionDto.getInvestedAmount())
													.investorId(fundSubscriptionDto.getInvestorId())
													.build();
		fundSubscriptionObj = fundSubscriptionRepository.save(fundSubscription);
																	
		return fundSubscriptionObj.getId();
	}

	@Override
	public List<SubscriptionVolumeByFund> getSubscriptionVolumePerFund() {
		 List<Object[]> result = fundSubscriptionRepository.findSubscriptionVolumeByFund();
		 List<SubscriptionVolumeByFund> subscriptionVolumeByFundList = new ArrayList<>();
		 result.forEach(object -> {
			 SubscriptionVolumeByFund subscriptionVolumeByFund = SubscriptionVolumeByFund.builder()
					 											.fundName((String)object[0])
					 											.fundVolume((BigDecimal)object[1])
					 											.build();
			 subscriptionVolumeByFundList.add(subscriptionVolumeByFund);
			 
		 } );
		 
		 return subscriptionVolumeByFundList;
		
	}

	@Override
	public List<SubscriptionVolumeByInvester> getSubscriptionVolumePerInvester() {
		
		List<Object[]> result = fundSubscriptionRepository.findSubscriptionVolumeByInvester();
		List<SubscriptionVolumeByInvester> subscriptionVolumeByInvesterList = new ArrayList<>();
		result.forEach(object -> {
			 SubscriptionVolumeByInvester subscriptionVolumeByInvester = SubscriptionVolumeByInvester.builder()
					 												.investerName((String)object[0])
					 												.fundVolume((BigDecimal)object[1])
					 												.build();
			 subscriptionVolumeByInvesterList.add(subscriptionVolumeByInvester);
			 
		 } );
		 
		 return subscriptionVolumeByInvesterList;
		
	}

}
