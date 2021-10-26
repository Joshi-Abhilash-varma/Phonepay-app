package com.phonepay.demo.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.phonepay.demo.dto.FundTransferDto;
import com.phonepay.demo.entity.FundTransfer;
import com.phonepay.demo.repository.FundTransferRepository;
import com.phonepay.demo.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService {
	
	@Autowired
	FundTransferRepository fundTransferRepository;

	@Override
	public List<FundTransferDto> getStatementFromMobileNumber(String mobileNumber, int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<FundTransfer> transferFund = fundTransferRepository.findByFromMobileNumber(mobileNumber, pageable);
		List<FundTransferDto> transferFundDto = transferFund.stream().map(this::changeFundTransferEnitytoDto).collect(Collectors.toList());
		return transferFundDto;
	}
	
	public FundTransferDto changeFundTransferEnitytoDto(FundTransfer fundTransfer) {
		FundTransferDto fundTransferDto = new FundTransferDto(fundTransfer.getFromMobileNumber(), fundTransfer.getToMobileNumber(), fundTransfer.getAmount(), fundTransfer.getComments());
		return fundTransferDto;
	}
	

}
