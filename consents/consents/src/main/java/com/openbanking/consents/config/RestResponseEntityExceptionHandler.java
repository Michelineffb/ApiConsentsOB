package com.openbanking.consents.config;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.openbanking.consents.errors.ErrorDetail;
import com.openbanking.consents.errors.ErrorMeta;
import com.openbanking.consents.errors.ResponseErrorDetails;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	public ResponseEntity<Object> meuErro(RuntimeException ex, WebRequest request){
		
		var errorResponse = new ResponseErrorDetails();
		
		var errorDetail = new ErrorDetail();
		errorDetail.setCode("400");
		errorDetail.setTitle("Bad Request");
		errorDetail.setDetail(ex.getMessage());
		
		errorResponse.getErrors().add(errorDetail);
		
		
		
		var errorMeta = new ErrorMeta();
		errorMeta.setRequestDateTime(new Date());
		errorMeta.setTotalPage(0);
		errorMeta.setTotalRecords(0);
		
		errorResponse.setMeta(errorMeta);

	
        return super.handleExceptionInternal(ex, errorResponse, 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        
	}
	

}

