package com.example.bankingapplication.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.Branch;
import com.example.bankingapplication.mapper.BranchMapper;
import com.example.bankingapplication.model.BranchModel;
import com.example.bankingapplication.repository.BranchRepository;
import com.example.bankingapplication.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	private final BranchRepository branchRepository;
	private final BranchMapper branchMapper;
	
	public BranchServiceImpl(BranchRepository branchRepository, 
			BranchMapper branchMapper) {
		this.branchRepository = branchRepository;
		this.branchMapper = branchMapper;
	}
	
	@Override
	public BranchModel saveBranch(BranchModel branchModel) {
		Branch branch = branchMapper.branchModelToBranch(branchModel);
		branch = branchMapper.branchModelToBranch(branchModel); 
		branch = branchRepository.save(branch);
		return branchMapper.branchToBranchModel(branch);
	}
	
	@Override
	public List<BranchModel> getAllBranches() {
		return branchMapper.branchListToBranchModelList(branchRepository.findAll());
	}
	
	@Override
	public BranchModel getBranchById(Integer id) {
		return branchMapper.branchToBranchModel(branchRepository.findById(id).get());
	}
	
}
