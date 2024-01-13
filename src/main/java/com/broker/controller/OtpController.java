package com.broker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.broker.service.OtpService;
import com.broker.service.UserService;

@RestController
@RequestMapping("/otp")
public class OtpController
{

	@Autowired
	private OtpService otpService;
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/generate/{phoneNumber}")
//	public String generateOtpCltrl(@PathVariable(value="phoneNumber")String PhoneNumber)
//	{
//		
//		return otpService.generateOtp(PhoneNumber);
//		
//	}
	
	
//	http://localhost:8081/otp/validate/8600450725?otp=811536
//	@GetMapping("/validate/{phoneNumber}")
//	 public boolean validateOtpCltrl(@PathVariable(value="phoneNumber")String phoneNumber,@RequestParam String otp)
//	 {
//		 return otpService.validateOtp(phoneNumber, otp);
//	 }
}
