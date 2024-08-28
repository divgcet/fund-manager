package com.test.fundmanager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.fundmanager.domain.OnboardingFlow;
import com.test.fundmanager.domain.Question;
import com.test.fundmanager.domain.Task;
import com.test.fundmanager.dto.OnboardingFlowDto;
import com.test.fundmanager.dto.QuestionDto;
import com.test.fundmanager.dto.TaskDto;
import com.test.fundmanager.jpa.OnboardingFlowRepository;

@Service
public class OnboardingFlowServiceImpl implements OnboardingFlowService {
	
	@Autowired
	private OnboardingFlowRepository onboardingFlowRepository;

	@Override
	public void createOnboardingFlow(OnboardingFlowDto onboardingFlowDto) {
		
		List<Task> taskList = convertTaskList(onboardingFlowDto.getTaskList());
		
		OnboardingFlow onboardingFlowObj = new OnboardingFlow(null, onboardingFlowDto.getFundId(), onboardingFlowDto.getInvestorType(), taskList);
		onboardingFlowRepository.save(onboardingFlowObj);
		
	}

	@Override
	public void updateOnboardingFlow(UUID fundId, OnboardingFlowDto onboardingFlow) {
		Optional<OnboardingFlow> onboardingFlowOptional = onboardingFlowRepository.findByFundId(fundId);
		OnboardingFlow savedOnboardingFlow = onboardingFlowOptional.orElseThrow(RuntimeException::new);
		savedOnboardingFlow.setInvestorType(onboardingFlow.getInvestorType());
		
		List<Task> taskList = convertTaskList(onboardingFlow.getTaskList());
		savedOnboardingFlow.setTaskList(taskList);
		onboardingFlowRepository.save(savedOnboardingFlow);
		
	}
	
	private List<Task> convertTaskList(List<TaskDto> taskDtoList) {
		List<Task> taskList = taskDtoList.stream()
        .map(taskDto -> new Task(null,convertQuestionList(taskDto.getQuestionDtoList())))
        .collect(Collectors.toList());
		return taskList;
	}
	
	private List<Question> convertQuestionList(List<QuestionDto> questionDtoList) {
		List<Question> questionList = questionDtoList.stream()
		        .map(questionDto -> new Question(null,questionDto.getText(), true))
		        .collect(Collectors.toList());
		return questionList;
	}

}
