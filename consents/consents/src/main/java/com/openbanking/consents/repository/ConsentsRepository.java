package com.openbanking.consents.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.openbanking.consents.model.Consents;

public interface ConsentsRepository extends MongoRepository<Consents, String>{
	

}
