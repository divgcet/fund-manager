package com.test.fundmanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name="DIRECTORDETAIL")
public class DirectorDetail {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String  lastName;
	
	@Column
	private String  countryOfResidence;

}
