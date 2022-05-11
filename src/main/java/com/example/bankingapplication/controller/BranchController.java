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
import com.example.bankingapplication.model.BranchModel;
import com.example.bankingapplication.service.BranchService;


@RestController
@RequestMapping("/branches")
public class BranchController {

	private static final String BRANCH_CREATED = "Branch created.";
	private static final String BRANCH_LIST = "Branch Listing..!";
	private static final String BRANCH_RECEIVED = "Branch created.";
	private static final String EXCEPTION = "Something went wrong.";

	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/")
	public APIResponseModel saveBranch(@RequestBody BranchModel branchModel) {
		try {
			BranchModel savedBranch = branchService.saveBranch(branchModel);
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, BRANCH_CREATED, savedBranch);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/")
	public APIResponseModel findAllBranches() {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, BRANCH_LIST, branchService.getAllBranches());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findBranchById(@PathVariable Integer id) {
		try {
			return new APIResponseModel(HttpStatus.OK.value(), HttpStatus.OK, BRANCH_RECEIVED, branchService.getBranchById(id));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new APIResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, EXCEPTION, null);
		}
	}
}
