package com.phonepay.demo.service.Impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonepay.demo.dto.FundTransferDto;
import com.phonepay.demo.entity.FundTransfer;
import com.phonepay.demo.exception.FromMobileNumberNotFoundException;
import com.phonepay.demo.exception.InsufficientBalanceException;
import com.phonepay.demo.exception.InvalidAccountException;
import com.phonepay.demo.exception.ToMobileNumberNotFoundException;
import com.phonepay.demo.feignclient.BankFeignClient;
import com.phonepay.demo.repository.FundTransferRepository;
import com.phonepay.demo.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService{
	
	@Autowired
	FundTransferRepository fundTransferRepository;
	
	@Autowired
	BankFeignClient bankFeignClient;
	
	@Override
	@Transactional
	public List<FundTransfer> transferMoney(FundTransferDto fundTransferDto) throws InsufficientBalanceException, FromMobileNumberNotFoundException, ToMobileNumberNotFoundException, InvalidAccountException {
		FundTransfer sourceAcc= new FundTransfer();
	//	FundTransfer targetAcc= new FundTransfer(); 
		Boolean checkTransfer = bankFeignClient.transferMoneyViaMobile(fundTransferDto);
		List<FundTransfer> listTransHistroy = new ArrayList<>();
		if(checkTransfer) {
         			//sourceAcc.setToMobileNumber(fundTransferDto.getFromMobileNumber());
         			sourceAcc.setFromMobileNumber(fundTransferDto.getFromMobileNumber());
         			sourceAcc.setToMobileNumber(fundTransferDto.getToMobileNumber());
         			sourceAcc.setAmount(fundTransferDto.getAmount());
         			sourceAcc.setComments(fundTransferDto.getComments());
         			sourceAcc.setTransactionDate(LocalDateTime.now());
         			fundTransferRepository.save(sourceAcc);
         			listTransHistroy.add(sourceAcc);	
         		}
         		else {
         			throw new InsufficientBalanceException("Insufficiant Amount !!!!");
         		}

		return listTransHistroy;

}

	/*@Override
	public String findByStatement(String fromMobileNmber) {
	
		return "Fund transfered successfully";
	}*/
	
	

}
