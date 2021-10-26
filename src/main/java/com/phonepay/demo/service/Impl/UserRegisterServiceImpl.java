package com.phonepay.demo.service.Impl;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.phonepay.demo.dto.UserRegisterDto;
import com.phonepay.demo.entity.UserRegister;
import com.phonepay.demo.exception.UserNotFoundException;
import com.phonepay.demo.feignclient.BankFeignClient;
import com.phonepay.demo.repository.UserRegisterRepository;
import com.phonepay.demo.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService{
	
	@Autowired
	UserRegisterRepository userRegisterRepository;
	
	@Autowired
	BankFeignClient bankFeignClient;
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;
	

	@Override
	public String addNewUserRegisterDetails(UserRegisterDto userRegisterDto) throws UserNotFoundException{
		UserRegister newUserRegisterDetails=new UserRegister();
			
			//System.out.println(userRegisterDto.getMobileNumber());
			//feignclient implementation for to check mobilenumber in bank service
			Boolean userCheck = bankFeignClient.getUserStatus(userRegisterDto.getMobileNumber());
			//System.out.println(userCheck);
			if(userCheck)
			{
				BeanUtils.copyProperties(userRegisterDto, newUserRegisterDetails);
				userRegisterRepository.save(newUserRegisterDetails);
				return "customer registered successfully";
				
				//throw new UsermobileException("User mobile number is not valid");
			}
			else
			{
				throw new  UserNotFoundException("No User Found For given mobile number");
				//return "Customer doesn't have a account in bak service";
			}
		}


	@Override
	public String getBankServicePortNo() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
		return circuitBreaker.run(() -> bankFeignClient.getPortNo() , throwable -> getDefaultInfo());
	}
	
	public String getDefaultInfo() {
		return "Service is down,Please try after some time";
	}
		
	}		
			
