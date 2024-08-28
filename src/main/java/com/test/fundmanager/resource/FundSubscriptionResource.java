package com.test.fundmanager.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fundmanager.dto.FundSubscriptionDto;
import com.test.fundmanager.dto.SubscriptionVolumeByFund;
import com.test.fundmanager.dto.SubscriptionVolumeByInvester;
import com.test.fundmanager.service.FundSubscriptionService;

@RestController
public class FundSubscriptionResource {
	
	@Autowired
	private FundSubscriptionService fundSubscriptionService;
	
	@PostMapping("/subscribeToFund")
	public ResponseEntity<String> subscribeToFund(@RequestBody FundSubscriptionDto requestBody) {
		
		Long fundSubscriptionId = fundSubscriptionService.subscribeToFund(requestBody);
		return new ResponseEntity<>("Fund subscription completed successfully with ID: "+fundSubscriptionId, HttpStatus.CREATED);
	}
	
	@GetMapping("/getSubscriptionVolumePerFund")
	public ResponseEntity<List<SubscriptionVolumeByFund>> getSubscriptionVolumePerFund() {
		
		List<SubscriptionVolumeByFund> subscriptionVolumeByFundList = fundSubscriptionService.getSubscriptionVolumePerFund();
		return new ResponseEntity<List<SubscriptionVolumeByFund>>(subscriptionVolumeByFundList, HttpStatus.OK);
	}
	
	@GetMapping("/getSubscriptionVolumePerInvester")
	public ResponseEntity<List<SubscriptionVolumeByInvester>> getSubscriptionVolumePerInvester() {
		
		List<SubscriptionVolumeByInvester> subscriptionVolumeByInvesterList = fundSubscriptionService.getSubscriptionVolumePerInvester();
		return new ResponseEntity<List<SubscriptionVolumeByInvester>>(subscriptionVolumeByInvesterList, HttpStatus.OK);
	}
	
}
