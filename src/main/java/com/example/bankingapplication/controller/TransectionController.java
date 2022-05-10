package com.example.bankingapplication.controller;

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
import com.example.bankingapplication.serviceimpl.TransectionServiceImpl;

@RestController
@RequestMapping("/transections")
public class TransectionController {

	@Autowired
	private TransectionServiceImpl transectionServiceImpl;
	
	@PostMapping("/")
	public APIResponseModel saveTransection(@RequestBody TransectionModel transectionModel) {
		return new APIResponseModel(200, HttpStatus.OK, "Transection Saved..!", transectionServiceImpl.saveTransection(transectionModel));
	}
	
	@GetMapping("/")
	public APIResponseModel findAllTransection() {
		return new APIResponseModel(200, HttpStatus.OK, "Transection Listing..!", transectionServiceImpl.getAllTransections());
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findTransectionById(@PathVariable Integer id) {
		return new APIResponseModel(200, HttpStatus.OK, "Transection Is Available..!", transectionServiceImpl.getTransectionById(id));
	}
}
