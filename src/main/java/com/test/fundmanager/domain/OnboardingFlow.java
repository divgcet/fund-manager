package com.test.fundmanager.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@Entity
@Table(name="OnboardingFlow")
public class OnboardingFlow {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private UUID fundId;
	
	@Column
	private String investorType;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Task> taskList;
	
	OnboardingFlow() {
		
	}
	
}
