package com.phonepay.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.phonepay.demo.dto.FundTransferDto;
import com.phonepay.demo.entity.FundTransfer;
import com.phonepay.demo.exception.FromMobileNumberNotFoundException;
import com.phonepay.demo.exception.InsufficientBalanceException;
import com.phonepay.demo.exception.InvalidAccountException;
import com.phonepay.demo.exception.ToMobileNumberNotFoundException;
import com.phonepay.demo.feignclient.BankFeignClient;
import com.phonepay.demo.service.Impl.FundTransferServiceImpl;

@ExtendWith(SpringExtension.class)
public class FundTransferServiceTest {
	
	@InjectMocks
	FundTransferServiceImpl fundTransferServiceImpl;
	
	@Mock
	FundTransferDto fundTransferDto;
	
	@Mock
	BankFeignClient bankFeignClient;
	
	@Test
	public void testTransferMoney(){
		
		FundTransfer fundTransfer= new FundTransfer();
		fundTransfer.setFromMobileNumber("9000000001");
		
		List<FundTransfer> transfers = new ArrayList<>();
		
		Mockito.when(bankFeignClient.transferMoneyViaMobile(fundTransferDto)).thenReturn(true);
		
		try {
			List<FundTransfer> fund = fundTransferServiceImpl.transferMoney(fundTransferDto);
			assertNotNull(fund);
			assertEquals("9000000001", fundTransferDto.getFromMobileNumber());
			
		} catch (InsufficientBalanceException | FromMobileNumberNotFoundException | ToMobileNumberNotFoundException
				| InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
