package com.broker.controller;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broker.model.Role;
import com.broker.model.User;
import com.broker.model.UserRole;
import com.broker.response.ResponseHandler;
import com.broker.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController{

	@Autowired
	private UserService userService;

	
	
	
   @PostMapping("/register")
	public ResponseEntity<Object> createUser(@RequestBody User user) throws Exception {
		Role role=new Role();
		role.setRoleId(11L);
		role.setName("seller");
		
		role.setRoleId(12L);
		role.setName("buyer");
		
		UserRole userrole =new UserRole();
		    userrole.setUser(user);
		    userrole.setRole(role);
		    
	     Set<UserRole> userRole = new HashSet<>();   
	     userRole.add(userrole);
	     
	     if(userRole.equals("seller"))
	     {
	    	 System.out.println("seller");
	     }
	     if(userRole.equals("buyer"))
	     {
	    	 System.out.println("Buyer");
	     }
//	     User createdUser = userService.createUser(user, userRole);
	     

	     
	     try {
	            User createdUser = userService.createUser(user, Collections.emptySet());
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user. " + e.getMessage());
	        }
	     
	     

//		return createdUser;
	}
	
	
	
}