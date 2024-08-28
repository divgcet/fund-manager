package com.test.fundmanager.service;

import java.util.UUID;

import com.test.fundmanager.dto.FundDto;

public interface FundService {

	public UUID createFund(FundDto fundDto);

}
