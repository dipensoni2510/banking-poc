package com.example.bankingapplication.model;

import com.example.bankingapplication.entity.Branch;
import com.example.bankingapplication.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerAccountModel {
	private Integer id;
	private Branch branch;
	private String accountNumber;
	private String accountBalance;
	private Customer customer;
	private String accountType;
	private String accountStatus;
}
