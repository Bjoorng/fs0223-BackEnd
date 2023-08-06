package com.main.exceptions;

import org.springframework.http.HttpStatus;

public class PersonalApiException extends RuntimeException {

	private HttpStatus status;
	private String message;

	public PersonalApiException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public PersonalApiException(String message, HttpStatus status, String message1) {
		super(message);
		this.status = status;
		this.message = message1;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
