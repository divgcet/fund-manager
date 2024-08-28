package com.test.fundmanager.jpa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.test.fundmanager.domain.FundSubscription;

public interface FundSubscriptionRepository extends CrudRepository<FundSubscription, Long> {
	
	Optional<FundSubscription> findByInvestorIdAndFundId(UUID investerId, UUID fundId);
	
	@Query(nativeQuery = true,
            value = "SELECT fundName, SUM(investedAmount) "
            + "FROM Fund "
            + "LEFT JOIN FundSubscription "
            + "ON Fund.Id=FundSubscription.fundId GROUP BY fundName ORDER BY investedAmount DESC")
	public List<Object[]> findSubscriptionVolumeByFund();
	
	@Query(nativeQuery = true,
            value = "SELECT CONCAT_WS(' ', firstName,lastName) as investerName, SUM(investedAmount) "
            + "FROM InvestorDetail "
            + "LEFT JOIN FundSubscription ON InvestorDetail.id=FundSubscription.investorId "
			+ " UNION "
			+ "SELECT companyName as investerName, SUM(investedAmount) "
			+ "FROM InstitutionalInvestorDetail "
			+ "LEFT JOIN FundSubscription ON InstitutionalInvestorDetail.id=FundSubscription.investorId "
			+  "GROUP BY investerName")
	public List<Object[]> findSubscriptionVolumeByInvester();
	
}