package com.phonepay.demo.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.phonepay.demo.entity.FundTransfer;

public interface FundTransferRepository extends JpaRepository<FundTransfer, Long>{
	
	//public List<FundTransfer> findByFromMobileNumber(String fromMobileNumber);
	
	public Optional<FundTransfer> findByFromMobileNumber(String fromMobileNumber);
	
	public List<FundTransfer> findByFromMobileNumber(String fromMobileNumber,Pageable pageable);

	@Query(value="select * from fund_transfer  where from_mobile_number=:fromMobileNumber and transaction_date between :transdate1 and :transdate2", nativeQuery=true)
	public List<FundTransfer> getTransDataByMobileNumberAndDate(@Param("fromMobileNumber") String fromMobileNumber,@Param("transdate1") LocalDateTime transdate1, @Param("transdate2")LocalDateTime transdate2);
}
