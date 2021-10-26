package com.phonepay.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import com.phonepay.demo.dto.UserRegisterDto;
import com.phonepay.demo.entity.UserRegister;
import com.phonepay.demo.exception.UserNotFoundException;
import com.phonepay.demo.feignclient.BankFeignClient;
import com.phonepay.demo.service.Impl.UserRegisterServiceImpl;

@ExtendWith(SpringExtension.class)
public class UserRegisterSeriveTest {

	@InjectMocks
	UserRegisterServiceImpl userRegisterServiceImpl;
	
	@Mock
	BankFeignClient bankFeignClient;
	
	@Mock
	UserRegisterDto userRegisterDto;
	
	
	@Test
	public void testAddNewUserDetails() throws UserNotFoundException {
		UserRegister userReg = new UserRegister();
		userReg.setMobileNumber("9966512485");
		Boolean value = true;
		
		Mockito.when(bankFeignClient.getUserStatus("9966512485")).thenReturn(value);
		
		//try {
			String response = userRegisterServiceImpl.addNewUserRegisterDetails(userRegisterDto);
			assertNotNull(response);
			assertEquals("9966512485", response);
	//	} catch (UserNotFoundException e) {
	//		e.printStackTrace();
	//	}
			
	
	}
}
