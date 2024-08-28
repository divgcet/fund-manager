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
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name="INSTITUTIONALINVESTORDETAIL")
public class InstitutionalInvestorDetail {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "COMPANYNAME")
	private String companyName;
	
	@Column
	private String countryOfIncorporation;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<DirectorDetail> directorList;
}
