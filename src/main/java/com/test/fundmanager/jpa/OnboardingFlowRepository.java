package com.test.fundmanager.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.test.fundmanager.domain.OnboardingFlow;

public interface OnboardingFlowRepository extends CrudRepository<OnboardingFlow, Long> {

	Optional<OnboardingFlow> findByFundId(UUID fundId);
	
}