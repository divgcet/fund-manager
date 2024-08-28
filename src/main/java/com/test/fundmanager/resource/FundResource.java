package com.test.fundmanager.resource;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fundmanager.dto.FundDto;
import com.test.fundmanager.service.FundService;


@RestController
public class FundResource {
	
	@Autowired
	private FundService fundService;
	
	@PostMapping("/createFund")
	public ResponseEntity<String> createFund(@RequestBody FundDto fundDto) {
		
		UUID fundId = fundService.createFund(fundDto);
        return new ResponseEntity<>("Fund created successfully with ID: "+fundId, HttpStatus.CREATED);
	}
	

}
