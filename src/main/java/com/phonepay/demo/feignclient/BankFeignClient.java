package com.phonepay.demo.feignclient;





import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonepay.demo.dto.FundTransferDto;



//@FeignClient(value = "bank-service", url="https://localhost:8088/bankpath/users")
@FeignClient(name = "https://BANK-SERVICE/bankpath")
public interface BankFeignClient {
	
	
	@GetMapping("/port")
	public String getPortNo();
	
	
	@GetMapping("/users/userDetails/{mobileNumber}")	
	public Boolean getUserStatus(@PathVariable String mobileNumber);
	
	@PostMapping("/users/bankdetails/fundtransfer")
	public void getByMobileNumber(@RequestParam String mobileNumber);
	
	@PostMapping("/transactions/fundtransfer/mobileNumber")
	public Boolean transferMoneyViaMobile(@RequestBody FundTransferDto fundTransferDto );

}
	


