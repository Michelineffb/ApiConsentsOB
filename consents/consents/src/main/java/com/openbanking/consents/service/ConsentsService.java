package com.openbanking.consents.service;

import com.openbanking.consents.model.Consents;

public interface ConsentsService {
	
	public Consents createConsent(Consents consents);
	
	public Consents consentsDetails(String id);

}
