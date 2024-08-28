package com.test.fundmanager.jpa;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.test.fundmanager.domain.InvestorDetail;

public interface InvesterRepository extends CrudRepository<InvestorDetail, UUID> {
	
}