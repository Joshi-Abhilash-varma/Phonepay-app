package com.phonepay.demo.service;

import java.util.List;

import com.phonepay.demo.dto.FundTransferDto;

public interface StatementService {
	
	
	public List<FundTransferDto> getStatementFromMobileNumber(String mobileNumber, int pageNumber,int PageSize);

}
