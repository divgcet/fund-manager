package com.test.fundmanager.resource;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fundmanager.dto.InstitutionalInvestorDetailDto;
import com.test.fundmanager.dto.InvestorDetailDto;
import com.test.fundmanager.service.InvesterService;

@RestController
public class InvesterResource {
	
	@Autowired
	private InvesterService investerService;
	
	@PostMapping("/createHNIInvester")
	public ResponseEntity<String> createHNIInvester(@RequestBody InvestorDetailDto investorBody) {
		
		UUID investerId =investerService.createHNIInvester(investorBody);
		return new ResponseEntity<>("HNI Invester created successfully with ID: "+investerId, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/createInstitutionalInvester")
	public ResponseEntity<String> createInstitutionalInvester(@RequestBody InstitutionalInvestorDetailDto investorBody) {
		
		UUID investerId = investerService.createInstitutionalInvester(investorBody);
		return new ResponseEntity<>("Institutional Invester successfully with ID: "+investerId, HttpStatus.CREATED);
	}

}
