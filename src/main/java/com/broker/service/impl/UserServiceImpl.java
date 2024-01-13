package com.broker.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broker.model.User;
import com.broker.model.UserRole;
import com.broker.repository.RoleRepository;
import com.broker.repository.UserRepository;
import com.broker.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user,Set<UserRole> userRoles) throws Exception
	{
		for (UserRole ur : userRoles)
		{
			roleRepository.save(ur.getRole());
		}
		
		String phoneNumber=user.getPhoneNumber();
		if(userRepository.existsByPhoneNumber(phoneNumber)) // make it return boolean
		{
			
         boolean isExist=userRepository.existsByPhoneNumber(phoneNumber);
//           User user1=new User();
         if(isExist)
         {
//           	 String otp = "1234";  
        	 Random r = new Random();
 			String otp = String.format("%06d", r.nextInt(100000));
        	 user.setOtp(otp);
              
             return user;
         }
         
         else
         {
            
     		user.getUserRoles().addAll(userRoles);
     		return userRepository.save(user);
        	 
         }
			
//			if(true){
//				// flag true opt send sendotp(phonebumber)
//			}
//			if false
//			// flag false registeration
//			
			
		
//			 throw new Exception("User with this phone number already exists.");
		}
		else
		{
		

		user.getUserRoles().addAll(userRoles);
		return userRepository.save(user);
		}
	}

	
	
}
