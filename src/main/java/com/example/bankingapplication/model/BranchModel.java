package com.example.bankingapplication.model;

import com.example.bankingapplication.entity.CustomerAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchModel {
	private Integer id;
	private String name;
	private String branchCode;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
    private CustomerAccount customerAccount;
}
