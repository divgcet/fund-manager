package com.test.fundmanager.dto;

import java.util.List;

import lombok.Data;

@Data
public class InstitutionalInvestorDetailDto {
	
	private String companyName;
	
	private String countryOfIncorporation;
	
	private List<DirectorDetailDto> directorDtoList;

}
