package com.openbanking.consents.service;

import org.springframework.http.ResponseEntity;

import com.openbanking.consents.model.Consents;

public interface ConsentsService {
	
	public Consents createConsent(Consents consents);
	
	public Consents consentsDetailsById(String id);
	
	public ResponseEntity<?> deleteConsents(String id);

}
