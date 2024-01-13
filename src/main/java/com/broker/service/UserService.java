package com.broker.service;

import java.util.List;
import java.util.Set;

import com.broker.model.User;
import com.broker.model.UserRole;

public interface UserService {

	

	public User  createUser(User user, Set<UserRole> userRole) throws Exception;


	
}
