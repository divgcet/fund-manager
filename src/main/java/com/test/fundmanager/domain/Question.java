package com.test.fundmanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name="Question")
public class Question {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String text;
	
	@Column
	private Boolean mandatory;
	
	Question() {
		
	}

}
