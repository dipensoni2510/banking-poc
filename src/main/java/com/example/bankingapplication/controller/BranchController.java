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
import com.example.bankingapplication.model.BranchModel;
import com.example.bankingapplication.serviceimpl.BranchServiceImpl;

@RestController
@RequestMapping("/branches")
public class BranchController {

	@Autowired
	private BranchServiceImpl branchServiceImpl;
	
	@PostMapping("/")
	public APIResponseModel saveBranch(@RequestBody BranchModel branchModel) {
		return new APIResponseModel(200, HttpStatus.OK, "Branch Saved..!", branchServiceImpl.saveBranch(branchModel));
	}
	
	@GetMapping("/")
	public APIResponseModel findAllBranches() {
		return new APIResponseModel(200, HttpStatus.OK, "Branch Listing..!", branchServiceImpl.getAllBranches());
	}
	
	@GetMapping("/{id}")
	public APIResponseModel findBranchById(@PathVariable Integer id) {
		return new APIResponseModel(200, HttpStatus.OK, "Branch Is Available..!", branchServiceImpl.getBranchById(id));
	}
}
