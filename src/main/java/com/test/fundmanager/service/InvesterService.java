package com.test.fundmanager.service;

import java.util.UUID;

import com.test.fundmanager.dto.InstitutionalInvestorDetailDto;
import com.test.fundmanager.dto.InvestorDetailDto;

public interface InvesterService {
	
	public UUID createHNIInvester(InvestorDetailDto investorDetailDto);
	
	public UUID createInstitutionalInvester(InstitutionalInvestorDetailDto institutionalInvestorDetailsDto);
	
}
