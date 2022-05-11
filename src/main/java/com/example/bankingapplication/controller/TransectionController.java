package com.example.bankingapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapplication.model.APIResponseModel;
import com.example.bankingapplication.model.TransectionModel;
import com.example.bankingapplication.service.TransectionService;

@RestController
@RequestMapping("/transections")
public class TransectionController {

	private static final String TRANSECTION_CREATED = "Transection Saved..!";
	private static final String TRANSECTION_LIST = "Transection List..!";
	private static final String TRANSECTION_RECEIVED = "Transection Is Available..!";
	private static final String EXCEPTION = "Something went wrong.";
	
	private static final Logger logger = LoggerFactory.getLogger(TransectionController.class);
	
	@Autowired
	private TransectionService transectionService;
	
	@PostMapping("/")
	public APIResponseModel saveTransection(@RequestBody TransectionModel transectionModel) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, TRANSECTION_CREATED, transectionService.saveTransection(transectionModel));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/")
	public APIResponseModel findAllTransection() {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, TRANSECTION_LIST, transectionService.getAllTransections());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findTransectionById(@PathVariable Integer id) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, TRANSECTION_RECEIVED, transectionService.getTransectionById(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
}
