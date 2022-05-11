package com.openbanking.consents.controller.dto;

import java.time.LocalDate;
import java.util.Date;

import com.openbanking.consents.model.Consents;

public class ConsentsDTO {
	private String id;
	private LocalDate transactionFromDateTime = LocalDate.now();
	private Date transactionToDateTime;
	
	public ConsentsDTO(Consents consents) {
		this.id = consents.getId();
		this.transactionFromDateTime = consents.getTransactionFromDateTime();
		this.transactionToDateTime = consents.getTransactionToDateTime();
	}
	
	public String getId() {
		return id;
	}
	public LocalDate getTransactionFromDateTime() {
		return transactionFromDateTime;
	}
	public Date getTransactionToDateTime() {
		return transactionToDateTime;
	}

}
