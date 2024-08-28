package com.test.fundmanager.jpa;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.test.fundmanager.domain.InstitutionalInvestorDetail;

public interface InstitutionalInvestorRepository extends CrudRepository<InstitutionalInvestorDetail, UUID> {
	
}