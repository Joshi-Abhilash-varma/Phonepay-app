package com.phonepay.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.phonepay.demo.dto.FundTransferDto;
import com.phonepay.demo.entity.FundTransfer;
import com.phonepay.demo.exception.FromMobileNumberNotFoundException;
import com.phonepay.demo.exception.InsufficientBalanceException;
import com.phonepay.demo.exception.InvalidAccountException;
import com.phonepay.demo.exception.ToMobileNumberNotFoundException;



public interface FundTransferService {

	public List<FundTransfer> transferMoney(FundTransferDto fundTransferDto) throws InsufficientBalanceException, FromMobileNumberNotFoundException, ToMobileNumberNotFoundException,InvalidAccountException;
	
	//public FundTransferDto transferMoney(FundTransferDto fundTransferDto) throws InsufficientBalanceException, FromMobileNumberNotFoundException, ToMobileNumberNotFoundException,InvalidAccountException;
	
	//PhonePayBankRepsonse transferByMobileNumber(BankRequest bankRequest);
	
	//public String findByStatement(String fromMobileNumber);
}
