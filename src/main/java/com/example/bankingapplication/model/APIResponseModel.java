package com.example.bankingapplication.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseModel {

	private int code;
	private HttpStatus status;
	private String message;
	private Object result;
	
}
