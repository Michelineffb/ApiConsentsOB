package com.openbanking.consents.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.openbanking.consents.controller.dto.ConsentsDTO;
import com.openbanking.consents.model.Consents;
import com.openbanking.consents.repository.ConsentsRepository;
import com.openbanking.consents.service.ConsentsService;

@RestController
@RequestMapping("/consents")
public class ConsentsController {
	
	@Autowired
	private ConsentsRepository consentsRepository;
	
	@Autowired
	private ConsentsService consentsService;
	
	@PostMapping
	public ResponseEntity<ConsentsDTO> createConsent(@Valid @RequestBody Consents consents, UriComponentsBuilder uriBuilder) {
		
			Consents newConsents = this.consentsService.createConsent(consents);
			
			return new ResponseEntity<>(new ConsentsDTO(consents), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Consents consentsDetails(@PathVariable String id) {
		return this.consentsService.consentsDetails(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable String id) {
		
		Optional<Consents> consents = consentsRepository.findById(id);
		if(consents.isPresent()) {
			consentsRepository.deleteById(id);
			
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}

