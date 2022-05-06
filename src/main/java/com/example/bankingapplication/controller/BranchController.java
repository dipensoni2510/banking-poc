package com.example.bankingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingapplication.model.BranchModel;
import com.example.bankingapplication.service.BranchServiceImpl;

@RestController
@RequestMapping("/branches")
public class BranchController {

	@Autowired
	private BranchServiceImpl branchServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<BranchModel> saveBranch(@RequestBody BranchModel branchModel) {
		return ResponseEntity.ok(branchServiceImpl.saveBranch(branchModel));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<BranchModel>> findAllBranches() {
		return ResponseEntity.ok(branchServiceImpl.getAllBranches());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BranchModel> findBranchById(@PathVariable Integer id) {
		return ResponseEntity.ok(branchServiceImpl.getBranchById(id));
	}
	
}
