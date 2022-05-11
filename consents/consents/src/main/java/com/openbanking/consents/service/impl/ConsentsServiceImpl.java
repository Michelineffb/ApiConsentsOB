package com.openbanking.consents.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openbanking.consents.model.Consents;
import com.openbanking.consents.repository.ConsentsRepository;
import com.openbanking.consents.service.ConsentsService;

@Service
public class ConsentsServiceImpl implements ConsentsService{
	
	@Autowired
	private ConsentsRepository consentsRepository;

	@Override
	public Consents createConsent(Consents consents) {
		// TODO Auto-generated method stub
		return this.consentsRepository.save(consents);
	}

	@Override
	public Consents consentsDetails(String id) {
		// TODO Auto-generated method stub
		return this.consentsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not Found"));
	}

}
