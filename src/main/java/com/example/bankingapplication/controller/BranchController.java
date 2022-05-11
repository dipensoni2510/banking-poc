package com.example.bankingapplication.controller;

import com.example.bankingapplication.service.BranchService;
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
import com.example.bankingapplication.serviceimpl.BranchServiceImpl;

@RestController
@RequestMapping("/branches")
public class BranchController {

	private static final String BRANCH_CREATED = "Branch created.";

	@Autowired
	private BranchService branchService;
	
	@PostMapping("/")
	public APIResponseModel saveBranch(@RequestBody BranchModel branchModel) {
		BranchModel savedBranch = branchService.saveBranch(branchModel);
		return new APIResponseModel(HttpStatus.OK, BRANCH_CREATED, savedBranch);
	}
	
	@GetMapping("/")
	public APIResponseModel findAllBranches() {
		return new APIResponseModel(200, HttpStatus.OK, "Branch Listing..!", branchService.getAllBranches());
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findBranchById(@PathVariable Integer id) {
		return new APIResponseModel(200, HttpStatus.OK, "Branch Is Available..!", branchService.getBranchById(id));
	}
}
