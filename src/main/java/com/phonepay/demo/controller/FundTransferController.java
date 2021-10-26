 package com.phonepay.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonepay.demo.dto.FundTransferDto;
import com.phonepay.demo.entity.FundTransfer;
import com.phonepay.demo.service.Impl.FundTransferServiceImpl;


@Validated
@RestController
@RequestMapping("/funds")
public class FundTransferController {
	
	@Autowired
	FundTransferServiceImpl fundTransferServiceImpl;
	

	@PostMapping("/payapp/fundtransfer")
	public List<FundTransfer> transferMoney(@Valid @RequestBody FundTransferDto fundTransferDto) throws Exception
	{
		return fundTransferServiceImpl.transferMoney(fundTransferDto);

	}
}
