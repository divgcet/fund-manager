package com.test.fundmanager.service;

import java.util.UUID;

import com.test.fundmanager.dto.OnboardingFlowDto;

public interface OnboardingFlowService {
	public void createOnboardingFlow(OnboardingFlowDto onboardingFlow);
	public void updateOnboardingFlow(UUID fundId, OnboardingFlowDto onboardingFlow);
	
}
