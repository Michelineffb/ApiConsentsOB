package com.openbanking.consents.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Date;
import java.util.Optional;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.openbanking.consents.AplicationConfigTest;
import com.openbanking.consents.model.Consents;
import com.openbanking.consents.repository.ConsentsRepository;

@DisplayName("ConsentsServiceImplTest")
class ConsentsServiceImplTest extends AplicationConfigTest{

	@MockBean
	private ConsentsRepository consentsRepository;
	
	@Autowired
	private ConsentsServiceImpl consentsServiceImpl;
	
	private Consents criarConsents() {
		Consents consents = Mockito.mock(Consents.class);
		
		return consents;
	}
	
	@Test
	@DisplayName("Deve criar um consents")
	public void createConsents() {
		Consents consents = criarConsents();
		
		consentsServiceImpl.createConsent(consents);
		Mockito.verify(consentsRepository, Mockito.times(1)).save(consents);
	}
	
	@Test
	@DisplayName("Deve buscar um consents")
	public void consentDetails() {
		String id = "id-mock";
		
		Optional<Consents> consents = Optional.of(criarConsents());
		Mockito.when(consentsRepository.findById(ArgumentMatchers.eq(id))).thenReturn(consents);
		
		consentsServiceImpl.consentsDetailsById(id);
		
		Mockito.verify(consentsRepository, Mockito.times(2)).findById(id);
	}
	
	@Test
	@DisplayName("Deve falhar em buscar um consents")
	public void consentDetailsError() {
		
		String id = "mock-id";
		
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> {consentsServiceImpl.consentsDetailsById(id);});
		
		Mockito.when(consentsRepository.findById(ArgumentMatchers.eq(id))).thenThrow(exception);
		
		assertEquals("Not Found", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Deve deletar um consents")
	public void deleteConsents() {
		
		String id = "id-mock";
		
		Optional<Consents> consents = Optional.of(criarConsents());
		Mockito.when(consentsRepository.findById(ArgumentMatchers.eq(id))).thenReturn(consents);
		
		consentsServiceImpl.deleteConsents(id);
		
		Mockito.verify(consentsRepository, Mockito.times(1)).deleteById(anyString());
		
	}
	
	@Test
	@DisplayName("Deve falhar em deletar um consents")
	public void deleteConsentsError() {
		
		String id = "id-mock";
		
		Exception exception = assertThrows(IllegalArgumentException.class, ()-> {consentsServiceImpl.deleteConsents(id);});
		
		Mockito.when(consentsRepository.findById(ArgumentMatchers.eq(id))).thenThrow(exception);
		
		assertEquals("Not Found", exception.getMessage());
		
	}


	

}
