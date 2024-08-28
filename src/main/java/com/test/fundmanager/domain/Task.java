package com.test.fundmanager.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
@Table(name="Task")
public class Task {
	
	@Id
	@GeneratedValue
	private Long taskId;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Question> questionList;
	
	Task() {
		
	}
}
