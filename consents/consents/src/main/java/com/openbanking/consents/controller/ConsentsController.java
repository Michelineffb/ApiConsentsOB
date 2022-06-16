package com.openbanking.consents.controller;

import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.openbanking.consents.config.ErrorValidationDTO;
import com.openbanking.consents.controller.dto.ConsentsDTO;
import com.openbanking.consents.errors.ResponseErrorDetails;
import com.openbanking.consents.model.Consents;
import com.openbanking.consents.repository.ConsentsRepository;
import com.openbanking.consents.service.ConsentsService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/consents/v1/consents")
public class ConsentsController {
	
	@Autowired
	private ConsentsRepository consentsRepository;
	
	@Autowired
	private ConsentsService consentsService;

	@PostMapping
	@ApiResponses({ 
	@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Consentimento criado com sucesso."),
	@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "O recurso solicitado não existe ou não foi implementado")
	})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ConsentsDTO> createConsent(@Valid @RequestBody Consents consents, UriComponentsBuilder uriBuilder) {
		
			Consents newConsents = this.consentsService.createConsent(consents);
			
			return new ResponseEntity<>(new ConsentsDTO(consents), HttpStatus.CREATED);
	}
	
	@ApiResponses({ 
		@ApiResponse(code = HttpServletResponse.SC_OK, message = "Consentimento consultado com sucesso."),
		@ApiResponse(code = 404, response = ResponseErrorDetails.class, message = "O recurso solicitado não existe ou não foi implementado")
		})
	@GetMapping("/{consentId}")
	public Consents consentsDetails(@PathVariable String consentId) {
		return this.consentsService.consentsDetailsById(consentId);
	}
	
	@ApiResponses({ 
		@ApiResponse(code = HttpServletResponse.SC_NO_CONTENT, message = "Consentimento revogado com sucesso."),
		@ApiResponse(code = 404, response = ErrorValidationDTO.class, message = "Consentimento revogado com sucesso.")
		})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{consentId}")
	public ResponseEntity<?> deleteConsents(@PathVariable String consentId) {
		this.consentsService.deleteConsents(consentId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
}

