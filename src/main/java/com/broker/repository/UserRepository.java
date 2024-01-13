package com.broker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broker.model.User;



public interface UserRepository extends JpaRepository<User,Long> {

	boolean existsByPhoneNumber(String phoneNumber);


	// User findByPhoneNumber(String phoneNumber);
//   public User findByPhone_no(String phone_no);
}
