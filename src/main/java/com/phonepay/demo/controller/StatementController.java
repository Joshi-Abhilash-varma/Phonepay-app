package com.phonepay.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonepay.demo.dto.FundTransferDto;
import com.phonepay.demo.service.Impl.StatementServiceImpl;

@RestController
@RequestMapping("/statements")
public class StatementController {
	
	@Autowired
	StatementServiceImpl statementServiceImpl;
	
	
	
	@GetMapping("/phonepestatement/{mobileNumber}")
	public List<FundTransferDto> getUserByMobileNumber(@RequestParam String mobileNumber,@RequestParam int pageNumber,@RequestParam int pageSize){
		
		return statementServiceImpl.getStatementFromMobileNumber(mobileNumber, pageNumber, pageSize);
	}

}
