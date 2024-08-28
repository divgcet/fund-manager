package com.test.fundmanager.resource;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.fundmanager.dto.OnboardingFlowDto;
import com.test.fundmanager.service.OnboardingFlowService;

@RestController
public class OnboardingFlowResource {
	
	@Autowired
	private OnboardingFlowService onboardingFlowService;
	
	@PostMapping("/createOnboardingFlow")
	public ResponseEntity<String> createOnboardingFlow(@RequestBody OnboardingFlowDto onboardingFlow) {
		
		onboardingFlowService.createOnboardingFlow(onboardingFlow);
        return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateOnboardingFlow/{fundId}")
	public ResponseEntity<String> updateOnboardingFlow(@PathVariable UUID fundId, @RequestBody OnboardingFlowDto onboardingFlow) {
		
		onboardingFlowService.updateOnboardingFlow(fundId, onboardingFlow);
        return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

}
 