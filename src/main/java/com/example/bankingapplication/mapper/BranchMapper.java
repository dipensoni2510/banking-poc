package com.example.bankingapplication.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bankingapplication.entity.Branch;
import com.example.bankingapplication.model.BranchModel;

@Mapper(componentModel = "spring")
public interface BranchMapper {

	BranchModel branchToBranchModel(Branch branch);
	Branch branchModelToBranch(BranchModel branchModel);
	List<BranchModel> branchListToBranchModelList(List<Branch> branchs);
	
}
