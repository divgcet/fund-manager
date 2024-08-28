package com.test.fundmanager.jpa;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.test.fundmanager.domain.Fund;

public interface FundRepository extends CrudRepository<Fund, UUID> {
	
}
