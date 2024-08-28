package com.test.fundmanager.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name="INVESTORDETAIL")
public class InvestorDetail {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "FIRSTNAME")
	private String firstName;
	
	@Column(name = "LASTNAME")
	private String  lastName;
	
	@Column
	private String  countryOfResidence;

}
