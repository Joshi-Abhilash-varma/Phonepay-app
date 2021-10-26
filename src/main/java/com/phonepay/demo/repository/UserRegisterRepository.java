package com.phonepay.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonepay.demo.dto.UserRegisterDto;
import com.phonepay.demo.entity.UserRegister;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister, Integer>{
	
	UserRegister findByMobileNumber(String mobileNumber);
	
	//UserRegisterDto findByMobileNumber(String mobileNumber,Pageable pageable);
	
	

}
