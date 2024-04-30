package com.interview.range.livingobjects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class LabelNotFoundException extends Exception {
	
	public LabelNotFoundException(String message) {
		super(message);
	}


}
