package com.test.fundmanager.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class OnboardingFlowDto {
	
	private UUID fundId;
	
	private String investorType;
	
	private List<TaskDto> taskList;
}
