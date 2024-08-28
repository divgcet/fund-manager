package com.test.fundmanager.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.fundmanager.domain.Fund;
import com.test.fundmanager.dto.FundDto;
import com.test.fundmanager.jpa.FundRepository;

@Service
public class FundServiceImpl implements FundService {
	
	@Autowired
	private FundRepository fundRepository;

	@Override
	public UUID createFund(FundDto fundDto) {
		Fund fund = new Fund(null, fundDto.getFundName(), fundDto.getMinimumInvestmentAmount());
		fund = fundRepository.save(fund);
		return fund.getId();
	};

}
