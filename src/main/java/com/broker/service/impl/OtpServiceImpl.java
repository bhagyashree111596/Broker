package com.broker.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.broker.model.OtpEntity;
import com.broker.repository.OtpRepository;
import com.broker.service.OtpService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OtpServiceImpl implements OtpService
{
     private OtpRepository otpRepository;
     
     
	@Override
	public String generateOtp(String phoneNumber)
	{
		String otp = String.format("%06d", new Random().nextInt(1000000));

        // Save the OTP to the database
        OtpEntity otpEntity = new OtpEntity();
//        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setOtp(otp);
//        String opty = Math.random();
//        sendmessage() top
        otpRepository.save(otpEntity);

        return otp;
		
	}

//	@Override
//	public boolean validateOtp(String phoneNumber, String otp)
//	{
//		 OtpEntity otpEntity = otpRepository.findById(phoneNumber).orElse(null);
//
//	        // Validate the OTP
//	        return otpEntity != null && otpEntity.getOtp().equals(otp);
//	}

}
