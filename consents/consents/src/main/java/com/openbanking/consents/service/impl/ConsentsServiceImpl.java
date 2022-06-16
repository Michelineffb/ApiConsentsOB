package com.openbanking.consents.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.openbanking.consents.model.Consents;
import com.openbanking.consents.repository.ConsentsRepository;
import com.openbanking.consents.service.ConsentsService;

import io.swagger.annotations.ApiResponse;

@Service
public class ConsentsServiceImpl implements ConsentsService{
	
	@Autowired
	private ConsentsRepository consentsRepository;
	
	@Autowired
	public ConsentsServiceImpl(ConsentsRepository consentsRepository) {
		this.consentsRepository = consentsRepository;
	}

	@Override
	public Consents createConsent(Consents consents) {
		
		return this.consentsRepository.save(consents);
	}

	@Override
	public Consents consentsDetailsById(String id) {
		
		Optional<Consents> optional = consentsRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new IllegalArgumentException("Not Found");
		
		}
		
		return this.consentsRepository.findById(id).get();
	}
	
	@Override
	public ResponseEntity<?> deleteConsents(String id) {
		
		Optional<Consents> optional = consentsRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new IllegalArgumentException("Not Found");
			
		}
		
		consentsRepository.deleteById(id);
		return ResponseEntity.ok().build();

	}
}


