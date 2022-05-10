package com.example.bankingapplication.service;

import java.util.List;

import com.example.bankingapplication.model.BranchModel;

public interface BranchService {

	BranchModel saveBranch(BranchModel branchModel);

	List<BranchModel> getAllBranches();

	BranchModel getBranchById(Integer id);

}
