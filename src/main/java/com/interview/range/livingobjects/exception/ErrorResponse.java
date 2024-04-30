package com.interview.range.livingobjects.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	private String apiPath;
	private HttpStatus statusMsg;
	private String errorMessage;
	private LocalDateTime errorTime;

}
