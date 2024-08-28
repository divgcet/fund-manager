package com.test.fundmanager.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.fundmanager.domain.DirectorDetail;
import com.test.fundmanager.domain.InstitutionalInvestorDetail;
import com.test.fundmanager.domain.InvestorDetail;
import com.test.fundmanager.dto.InstitutionalInvestorDetailDto;
import com.test.fundmanager.dto.InvestorDetailDto;
import com.test.fundmanager.jpa.InstitutionalInvestorRepository;
import com.test.fundmanager.jpa.InvesterRepository;

@Service
public class InvesterServiceImpl implements InvesterService{
	
	@Autowired
	private InvesterRepository investerRepository;
	
	@Autowired
	private InstitutionalInvestorRepository institutionalInvestorRepository;
	

	@Override
	public UUID createHNIInvester(InvestorDetailDto InvestorDetailDto) {
		InvestorDetail investorDetailPersistingObj =  InvestorDetail.builder().countryOfResidence(InvestorDetailDto.getCountryOfResidence())
													.firstName(InvestorDetailDto.getFirstName())
													.lastName(InvestorDetailDto.getLastName()).build();
		InvestorDetail investorDetailObj = investerRepository.save(investorDetailPersistingObj);
		return investorDetailObj.getId();
	}


	@Override
	public UUID createInstitutionalInvester(InstitutionalInvestorDetailDto institutionalInvestorDetailsDto) {
		
		List<DirectorDetail> directorList = institutionalInvestorDetailsDto.getDirectorDtoList().stream()
		        .map(directorDto -> new DirectorDetail(null,directorDto.getFirstName(),directorDto.getLastName(),directorDto.getCountryOfResidence()))
		        .collect(Collectors.toList());
		
		InstitutionalInvestorDetail institutionalInvestorDetailObj =  InstitutionalInvestorDetail.builder()
																			.companyName(institutionalInvestorDetailsDto.getCompanyName())
																			.countryOfIncorporation(institutionalInvestorDetailsDto.getCountryOfIncorporation())
																			.directorList(directorList).build();
		InstitutionalInvestorDetail investorDetailObj = institutionalInvestorRepository.save(institutionalInvestorDetailObj);	
		return investorDetailObj.getId();
		
	}
	
}
