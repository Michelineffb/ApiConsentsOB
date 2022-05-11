package com.openbanking.consents.errors;

import java.util.ArrayList;
import java.util.List;

public class ResponseErrorDetails {
	private List<ErrorDetail> errors = new ArrayList();
	private ErrorMeta meta;
	
	public List<ErrorDetail> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}
	public ErrorMeta getMeta() {
		return meta;
	}
	public void setMeta(ErrorMeta meta) {
		this.meta = meta;
	}

}
