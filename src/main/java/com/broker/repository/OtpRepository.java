package com.broker.repository;

import org.springframework.data.repository.CrudRepository;

import com.broker.model.OtpEntity;

public interface OtpRepository extends CrudRepository<OtpEntity, String>
{

}
